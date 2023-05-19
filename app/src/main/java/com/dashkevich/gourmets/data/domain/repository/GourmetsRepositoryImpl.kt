package com.dashkevich.gourmets.data.domain.repository

import android.content.Context
import com.dashkevich.gourmets.data.api.GourmetsService
import com.dashkevich.gourmets.data.api.model.Category
import com.dashkevich.gourmets.data.api.model.TagX
import com.dashkevich.gourmets.data.util.coroutineCatching
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStream
import java.util.*


class GourmetsRepositoryImpl(
    private val context: Context,
    private val gourmetsService: GourmetsService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : GourmetsRepository {

    private val mockWebService by lazy { MockWebServer() }
    private val fakeApi by lazy {
        Retrofit.Builder()
            .baseUrl(mockWebService.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(GourmetsService::class.java)
    }

    override suspend fun getTags()
            : Result<List<TagX>> {
        return coroutineCatching(dispatcher) {
            mockWebService.start()
            mockWebService.enqueueDefault(
                context = context,
                filename = "tags.json",
            )
            val result = fakeApi.getTags()
            mockWebService.shutdown()
            result
        }
    }

    override suspend fun getCategories()
            : Result<List<Category>> = coroutineCatching(dispatcher) {
        gourmetsService.getCategories()
    }

}

fun MockWebServer.enqueueDefault(
    filename: String,
    code: Int = 200,
    context: Context,
    filterText: (InputStream) -> String = { inputStream ->
//        val sb: StringBuilder = StringBuilder()
//        var ch: Int = 0
//        while (inputStream.read().also { ch = it } != -1) {
//            sb.append(ch.toChar())
//        }
//        sb.toString()
        val scan = Scanner(inputStream).useDelimiter("\\A")
        val result = if(scan.hasNext()){
            scan.next()
        }
        else {
            ""
        }
        result
    }
) {
    val inputStream = context.assets.open(filename)//.source().buffer()
    val json = filterText(inputStream)
    enqueue(MockResponse().setResponseCode(code).setBody(json))
}
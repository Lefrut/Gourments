package com.dashkevich.gourmets.data.domain.repository

import android.content.Context
import com.dashkevich.gourmets.data.api.GourmetsService
import com.dashkevich.gourmets.data.api.model.Category
import com.dashkevich.gourmets.data.api.model.Product
import com.dashkevich.gourmets.data.api.model.TagX
import com.dashkevich.gourmets.data.util.coroutineCatching
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import productsS
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
    private var firstLaunch = true

    override suspend fun getTags()
            : Result<List<TagX>> {
        return coroutineCatching(dispatcher) {
            mockWebService.enqueueDefault(
                context = context,
                filename = "tags.json",
            )
            fakeApi.getTags()
        }
    }

    override suspend fun getCategories()
            : Result<List<Category>> = coroutineCatching(dispatcher) {
        if(firstLaunch){
            mockWebService.start()
            firstLaunch = false
        }
        mockWebService.enqueueDefault(
            context = context,
            filename = "categories.json",
        )
        fakeApi.getCategories()
    }

    override suspend fun getProducts(idTags: List<Int>, idCategory: Int): Result<List<Product>> {
        return coroutineCatching(dispatcher) {
            mockWebService.enqueueDefault(
                context = context,
                filename = "products.json",
                filterText = { inputStream ->
                    val json = Gson().toJson(productsS)
                    json
                }
            )
            fakeApi.getProducts(idTags, idCategory)
        }
    }

    override fun shutDown() {
        mockWebService.shutdown()
    }

    override fun start() {
        mockWebService.start()
    }

}

@Synchronized
fun MockWebServer.enqueueDefault(
    filename: String,
    code: Int = 200,
    context: Context,
    filterText: (InputStream) -> String = { inputStream ->
        val scan = Scanner(inputStream).useDelimiter("\\A")
        val result = if (scan.hasNext()) {
            scan.next()
        } else {
            ""
        }
        result
    }
) {
    synchronized(this) {
        val inputStream = context.assets.open(filename)//.source().buffer()
        val json = filterText(inputStream)
        enqueue(MockResponse().setResponseCode(code).setBody(json))
    }
}
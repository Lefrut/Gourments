package com.dashkevich.gourmets.data.domain.repository

import android.content.Context
import com.dashkevich.gourmets.data.api.GourmetsService
import com.dashkevich.gourmets.data.api.model.Category
import com.dashkevich.gourmets.data.api.model.Product
import com.dashkevich.gourmets.data.util.coroutineCatching
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStream
import java.util.concurrent.TimeUnit

class GourmetsRepositoryImpl(
    private val context: Context,
    private val gourmetsService: GourmetsService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : GourmetsRepository {

    private val client = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.SECONDS)
        .readTimeout(1, TimeUnit.SECONDS)
        .writeTimeout(1, TimeUnit.SECONDS)
        .build()

    private val mockWebService by lazy { MockWebServer() }
    private val fakeApi by lazy {
        Retrofit.Builder()
            .baseUrl(mockWebService.url("/"))
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(GourmetsService::class.java)
    }

    override suspend fun getCategories(): Result<List<Category>> {
        return coroutineCatching(dispatcher) {
            mockWebService.start()
            mockWebService.enqueueDefault(
                filename = "categories.json",
                context = context,
                filterText = { inputStream ->
                    ""
                }
            )
            val result = fakeApi.getCategories()
            mockWebService.shutdown()
            result
        }
    }

    override suspend fun getProduct(id: Int): Result<Product> {
        return coroutineCatching(dispatcher) {
            mockWebService.start()
            mockWebService.enqueueDefault(
                filename = "products.json",
                context = context,
                filterText = { inputStream ->

                    ""
                }
            )
            val result = fakeApi.getProduct(id)
            mockWebService.shutdown()
            result
        }
    }

}


fun MockWebServer.enqueueDefault(
    filename: String,
    code: Int = 200,
    context: Context,
    filterText: (InputStream) -> String
) {
    val inputStream = context.assets.open(filename)//.source().buffer()
    val json = filterText(inputStream)
    enqueue(MockResponse().setResponseCode(code).setBody(json))
}
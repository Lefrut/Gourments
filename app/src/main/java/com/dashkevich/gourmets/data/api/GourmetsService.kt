package com.dashkevich.gourmets.data.api

import com.dashkevich.gourmets.data.api.model.Category
import com.dashkevich.gourmets.data.api.model.Product
import retrofit2.http.GET
import retrofit2.http.Path


interface GourmetsService {

    @GET(Endpoints.GET_CATEGORIES)
    suspend fun getCategories() : List<Category>

    @GET(Endpoints.GET_PRODUCT + "/{id}")
    suspend fun getProduct(@Path("id") id: Int) : Product
}
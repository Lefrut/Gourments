package com.dashkevich.gourmets.data.api

import com.dashkevich.gourmets.data.api.model.Category
import retrofit2.http.GET


interface GourmetsService {

    @GET(Endpoints.GET_CATEGORIES)
    suspend fun getCategories() : List<Category>

}
package com.dashkevich.gourmets.data.api

import com.dashkevich.gourmets.data.api.model.Category
import com.dashkevich.gourmets.data.api.model.TagX
import retrofit2.http.GET


interface GourmetsService {

    @GET(Endpoints.GET_CATEGORIES)
    suspend fun getCategories() : List<Category>

    @GET(Endpoints.GET_TAGS)
    suspend fun getTags() : List<TagX>
}
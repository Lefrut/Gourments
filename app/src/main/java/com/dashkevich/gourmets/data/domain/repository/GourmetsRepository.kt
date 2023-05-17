package com.dashkevich.gourmets.data.domain.repository

import com.dashkevich.gourmets.data.api.model.Category

interface GourmetsRepository {

    suspend fun getCategories() : Result<List<Category>>

}
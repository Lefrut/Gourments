package com.dashkevich.gourmets.data.domain.repository

import com.dashkevich.gourmets.data.api.model.Category
import com.dashkevich.gourmets.data.api.model.Product

interface GourmetsRepository {

    suspend fun getCategories() : Result<List<Category>>

    suspend fun getProduct(id: Int) : Result<Product>

}
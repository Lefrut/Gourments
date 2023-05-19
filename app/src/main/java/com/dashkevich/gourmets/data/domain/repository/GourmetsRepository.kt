package com.dashkevich.gourmets.data.domain.repository

import com.dashkevich.gourmets.data.api.model.Category
import com.dashkevich.gourmets.data.api.model.Product
import com.dashkevich.gourmets.data.api.model.TagX

interface GourmetsRepository {

    suspend fun getTags() : Result<List<TagX>>

    suspend fun getCategories() : Result<List<Category>>

    suspend fun getProducts(idTags: List<Int>, idCategory: Int): Result<List<Product>>

    fun shutDown()

    fun start()

}
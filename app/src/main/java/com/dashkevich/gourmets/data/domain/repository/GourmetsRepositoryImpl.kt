package com.dashkevich.gourmets.data.domain.repository

import com.dashkevich.gourmets.data.api.GourmetsService
import com.dashkevich.gourmets.data.api.model.Category
import com.dashkevich.gourmets.data.api.model.Product
import com.dashkevich.gourmets.data.util.coroutineCatching
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class GourmetsRepositoryImpl(
    private val gourmetsService: GourmetsService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : GourmetsRepository {

    override suspend fun getCategories()
            : Result<List<Category>> = coroutineCatching(dispatcher) {
        gourmetsService.getCategories()
    }

    override suspend fun getProduct(id: Int)
            : Result<Product> = coroutineCatching(dispatcher) {
        gourmetsService.getProduct(id)
    }

}
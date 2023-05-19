package com.dashkevich.gourmets.ui.screens.catalog.model.mvi

import com.dashkevich.gourmets.common.OperationState
import com.dashkevich.gourmets.data.api.model.Category
import com.dashkevich.gourmets.data.api.model.Product
import com.dashkevich.gourmets.data.api.model.TagX
import com.dashkevich.gourmets.ui.util.ProductBasket

data class CatalogState(
    val categoriesTab: CategoriesTab = CategoriesTab(),
    val selectedTab: Int = 0,
    val filters: List<Pair<TagX, Boolean>> = emptyList(),
    val openBottomSheet: Boolean = false,
    val productList: List<Product> = emptyList(),
    val productsBasket: Map<Int, Int> = ProductBasket.getProducts().toMap(),
    val totalPrice: Int = 0
)

class CategoriesTab(
    val categories: List<Category> = emptyList(),
    val state: OperationState = OperationState.None
)



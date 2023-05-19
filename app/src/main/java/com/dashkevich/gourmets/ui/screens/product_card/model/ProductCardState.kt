package com.dashkevich.gourmets.ui.screens.product_card.model

import com.dashkevich.gourmets.data.api.model.Product
import com.dashkevich.gourmets.ui.util.ProductBasket

data class ProductCardState(
    val product: List<Product> = emptyList(),
    val productsBasket: Map<Int, Int> = ProductBasket.getProducts().toMap()
)

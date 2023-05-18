package com.dashkevich.gourmets.ui.screens.product_card.model

import com.dashkevich.gourmets.data.api.model.Product

data class ProductCardState(
    val product: List<Product> = emptyList(),
)

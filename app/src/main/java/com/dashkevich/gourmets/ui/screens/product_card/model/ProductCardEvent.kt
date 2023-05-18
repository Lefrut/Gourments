package com.dashkevich.gourmets.ui.screens.product_card.model

sealed class ProductCardEvent() {
    object ClickedArrowBack: ProductCardEvent()
    object ClickedBuyButton: ProductCardEvent()
}
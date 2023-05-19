package com.dashkevich.gourmets.ui.screens.product_card.model

sealed class ProductCardEvent() {
    class ClickedBuyButton(val idProduct: Int) : ProductCardEvent()
    class ClickedMinus(val idProduct: Int) : ProductCardEvent()
    object ClickedArrowBack : ProductCardEvent()
}
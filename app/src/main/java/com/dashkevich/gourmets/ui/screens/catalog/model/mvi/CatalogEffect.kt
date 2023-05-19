package com.dashkevich.gourmets.ui.screens.catalog.model.mvi

sealed class CatalogEffect(){

    class NavigateToProductCard(val idProduct: Int): CatalogEffect()
}

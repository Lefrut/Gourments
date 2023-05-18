package com.dashkevich.gourmets.ui.screens.catalog.model.mvi

sealed class CatalogEvent(){
    object ClickedFilter: CatalogEvent()
    object ClickedSearch: CatalogEvent()
    class ClickedTab(val indexTab: Int): CatalogEvent()
    class ClickedFoodCard(val idFood: Int)

}

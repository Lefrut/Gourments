package com.dashkevich.gourmets.ui.screens.catalog.model.mvi

sealed class CatalogIntent(){
    object ClickedFilter: CatalogIntent()
    object ClickedSearch: CatalogIntent()
    class ClickedTab(val indexTab: Int): CatalogIntent()
    //Todo("Implement room class")
    class ClickedFoodCard(val idFood: Int)
    object VisitScreen: CatalogIntent()

}

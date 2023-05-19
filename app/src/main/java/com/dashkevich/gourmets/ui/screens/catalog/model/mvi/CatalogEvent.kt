package com.dashkevich.gourmets.ui.screens.catalog.model.mvi

sealed class CatalogEvent(){
    object ClickedFilter: CatalogEvent()
    object ClickedSearch: CatalogEvent()
    class ClickedTab(val indexTab: Int): CatalogEvent()
    class ClickedFoodCard(val idFood: Int): CatalogEvent()
    class ClickedItemFilter(val index: Int,val newState: Boolean): CatalogEvent()
    class ClickedButtonFilter() : CatalogEvent()
    class CloseBottomSheet(val value: Boolean): CatalogEvent()
    class SelectedTab(val index: Int) : CatalogEvent()
    class ClickedCardButton(val idProduct: Int) : CatalogEvent()
    class ClickedMinusCounter(val idProduct: Int) : CatalogEvent()

}

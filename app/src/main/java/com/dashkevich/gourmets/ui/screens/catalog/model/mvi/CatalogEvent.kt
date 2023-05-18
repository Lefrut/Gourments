package com.dashkevich.gourmets.ui.screens.catalog.model.mvi

import java.util.Calendar

sealed class CatalogEvent(){
    object ClickedFilter: CatalogEvent()
    object ClickedSearch: CatalogEvent()
    class ClickedTab(val indexTab: Int): CatalogEvent()
    class ClickedFoodCard(val idFood: Int): CatalogEvent()
    class ClickedItemFilter(index: Int, newState: Boolean): CatalogEvent()
    class ClickedButtonFilter() : CatalogEvent()
    class CloseBottomSheet(value: Boolean): CatalogEvent()

}

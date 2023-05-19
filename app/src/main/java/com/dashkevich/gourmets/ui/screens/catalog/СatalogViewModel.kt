package com.dashkevich.gourmets.ui.screens.catalog

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.dashkevich.gourmets.common.OperationState
import com.dashkevich.gourmets.common.mvi.MVIViewModel
import com.dashkevich.gourmets.data.domain.repository.GourmetsRepository
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CatalogEffect
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CatalogEvent
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CatalogState
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CategoriesTab
import kotlinx.coroutines.launch

class CatalogViewModel(
    private val gourmetsRepository: GourmetsRepository
) : MVIViewModel<CatalogEvent, CatalogState, CatalogEffect>() {


    init {
        getCategories()
    }

    private fun getCategories() = viewModelScope.launch {
        setState {
            copy(categoriesTab = CategoriesTab(state = OperationState.Loading))
        }
        gourmetsRepository.getCategories().onSuccess { categories ->
            val state = if (categories.isEmpty()) OperationState.EmptyResult
            else OperationState.Success

            setState {
                copy(categoriesTab = CategoriesTab(categories, state))
            }
        }.onFailure {
            setState {
                copy(
                    categoriesTab = CategoriesTab(state = OperationState.Error)
                )
            }
        }
    }

    override fun setInitialState(): CatalogState = CatalogState()

    override fun handleEvents(event: CatalogEvent) {
        when (event) {
            CatalogEvent.ClickedFilter -> {
                setState { copy(openBottomSheet = !openBottomSheet) }
                if(viewState.value.filters.isEmpty()){
                    viewModelScope.launch {
                        gourmetsRepository.getTags().onSuccess { tags ->
                            val filters = tags.map { Pair(it, false) }
                            Log.i("DebugCatalog", filters.toString())
                            setState { copy(filters = filters) }
                        }.onFailure {
                            Log.e("DebugCatalog", it.message.toString())
                        }
                    }
                }
            }
            CatalogEvent.ClickedSearch -> {

            }
            is CatalogEvent.ClickedTab -> {

            }
            is CatalogEvent.ClickedButtonFilter -> {

            }
            is CatalogEvent.ClickedFoodCard -> {

            }
            is CatalogEvent.ClickedItemFilter -> {
                val (index, value) = Pair(event.index, event.newState)
                val mutableList = viewState.value.filters.toMutableList()
                mutableList[index] = mutableList[index].copy(second = value)
                setState { copy(
                    filters = mutableList.toList()
                ) }
            }
            is CatalogEvent.CloseBottomSheet -> {

            }
        }
    }


}
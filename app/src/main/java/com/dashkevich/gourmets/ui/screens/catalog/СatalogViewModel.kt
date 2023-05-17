package com.dashkevich.gourmets.ui.screens.catalog

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.dashkevich.gourmets.common.OperationState
import com.dashkevich.gourmets.common.mvi.BaseViewModel
import com.dashkevich.gourmets.data.domain.repository.GourmetsRepository
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CatalogIntent
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CatalogState
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CategoriesTab
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CatalogViewModel(
    private val gourmetsRepository: GourmetsRepository
) : BaseViewModel<CatalogState, CatalogIntent>() {
    private val _viewState = MutableStateFlow(CatalogState())
    override val viewState: StateFlow<CatalogState> = _viewState.asStateFlow()

    override fun processingIntent(intent: CatalogIntent) {
        when (intent) {
            CatalogIntent.ClickedFilter -> {}
            CatalogIntent.ClickedSearch -> {}
            is CatalogIntent.ClickedTab -> {}
            CatalogIntent.VisitScreen -> {
                Log.i("CatalogViewModel", "Visit Screen used")
                getCategories()
            }
        }
    }

    private fun getCategories() = viewModelScope.launch {
        _viewState.value =
            viewState.value.copy(categoriesTab = CategoriesTab(state = OperationState.Loading))
        gourmetsRepository.getCategories().onSuccess { categories ->
            val state = if (categories.isEmpty()) OperationState.EmptyResult
            else OperationState.Success
            _viewState.value = viewState.value.copy(
                categoriesTab = CategoriesTab(categories, state)
            )
        }.onFailure {
            _viewState.value = viewState.value.copy(
                categoriesTab = CategoriesTab(state = OperationState.Error)
            )
        }
    }


}
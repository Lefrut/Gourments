package com.dashkevich.gourmets.ui.screens.catalog

import com.dashkevich.gourmets.common.mvi.BaseViewModel
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CatalogIntent
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CatalogState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CatalogViewModel(): BaseViewModel<CatalogState,CatalogIntent>() {
    private val _viewState = MutableStateFlow(CatalogState())
    override val viewState: StateFlow<CatalogState> = _viewState.asStateFlow()

    override fun processingIntent(intent: CatalogIntent) {
        when(intent){
            else -> { }
        }
    }


}
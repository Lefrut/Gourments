package com.dashkevich.gourmets.ui.screens.catalog.model.mvi

import com.dashkevich.gourmets.common.OperationState
import com.dashkevich.gourmets.data.api.model.Category

data class CatalogState(
    val categoriesTab: CategoriesTab = CategoriesTab()
)

class CategoriesTab(
    val categories: List<Category> = emptyList(),
    val state: OperationState = OperationState.None
)



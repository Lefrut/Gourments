package com.dashkevich.gourmets.ui.screens.catalog.model.mvi

import com.dashkevich.gourmets.common.OperationState
import com.dashkevich.gourmets.data.api.model.Category
import com.dashkevich.gourmets.data.api.model.TagX

data class CatalogState(
    val categoriesTab: CategoriesTab = CategoriesTab(),
    val filters: List<Pair<TagX, Boolean>> = emptyList(),
    val openBottomSheet: Boolean = false
)

class CategoriesTab(
    val categories: List<Category> = emptyList(),
    val state: OperationState = OperationState.None
)



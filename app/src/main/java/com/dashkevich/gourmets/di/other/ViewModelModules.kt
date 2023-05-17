package com.dashkevich.gourmets.di.other

import com.dashkevich.gourmets.ui.screens.catalog.CatalogViewModel
import com.dashkevich.gourmets.ui.screens.product_card.ProductCardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel{
        CatalogViewModel()
    }

    viewModel{
        ProductCardViewModel()
    }

}
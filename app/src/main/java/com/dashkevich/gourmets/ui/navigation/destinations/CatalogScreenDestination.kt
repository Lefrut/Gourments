package com.dashkevich.gourmets.ui.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.dashkevich.gourmets.ui.screens.catalog.CatalogScreen
import com.dashkevich.gourmets.ui.screens.catalog.CatalogViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun CatalogScreenDestination(navController: NavController) {
    val catalogViewModel = getViewModel<CatalogViewModel>()
    val viewState by catalogViewModel.viewState.collectAsState()
    CatalogScreen(
        viewState, { event -> catalogViewModel.processingIntent(event) },
        navController
    )
}
package com.dashkevich.gourmets.ui.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.dashkevich.gourmets.ui.screens.product_card.ProductCardScreen
import com.dashkevich.gourmets.ui.screens.product_card.ProductCardViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun ProductCardScreenDestination(navController: NavController, productId: Int) {
    val productCardViewModel = getViewModel<ProductCardViewModel>() { parametersOf(productId) }
    ProductCardScreen(
        viewState = productCardViewModel.viewState.value,
        effectFlow = productCardViewModel.effect,
        onSendEvent = { event -> productCardViewModel.setEvent(event) },
        navController = navController,
    )
}
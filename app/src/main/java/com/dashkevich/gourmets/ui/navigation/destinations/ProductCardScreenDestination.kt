package com.dashkevich.gourmets.ui.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.dashkevich.gourmets.data.model.Product
import com.dashkevich.gourmets.ui.screens.product_card.ProductCardScreen
import com.dashkevich.gourmets.ui.screens.product_card.ProductCardViewModel
import com.dashkevich.gourmets.ui.util.productJsonExample
import com.google.gson.Gson
import org.koin.androidx.compose.getViewModel

@Composable
fun ProductCardScreenDestination(navController: NavController, productId: Int) {
    val productCardViewModel = getViewModel<ProductCardViewModel>()
    ProductCardScreen(
        viewState = productCardViewModel.viewState.value,
        effectFlow = productCardViewModel.effect,
        onSendEvent = { event -> productCardViewModel.setEvent(event)},
        navController = navController,
        productId = productId
    )
}
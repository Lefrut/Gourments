package com.dashkevich.gourmets.ui.screens.product_card

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dashkevich.gourmets.R
import com.dashkevich.gourmets.data.model.Product
import com.dashkevich.gourmets.ui.screens.product_card.components.BackArrow
import com.dashkevich.gourmets.ui.components.BottomButton
import com.dashkevich.gourmets.ui.screens.product_card.components.FoodParamItem
import com.dashkevich.gourmets.ui.screens.product_card.model.ProductCardEffect
import com.dashkevich.gourmets.ui.screens.product_card.model.ProductCardEvent
import com.dashkevich.gourmets.ui.screens.product_card.model.ProductCardState
import com.dashkevich.gourmets.ui.theme.Theme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun ProductCardScreen(
    viewState: ProductCardState,
    effectFlow: Flow<ProductCardEffect>,
    onSendEvent: (event: ProductCardEvent) -> Unit,
    navController: NavController,
    product: Product
) {
    Box {
        BackArrow(onClick = { onSendEvent(ProductCardEvent.ClickedArrowBack) })
    }
    LaunchedEffect(key1 = Unit){
        effectFlow.onEach { effect ->
            when(effect){
                ProductCardEffect.NavigateBack -> {
                    Log.i("ProductCardScreen", "Effect active")
                    navController.popBackStack()
                }
            }
        }.collect()
    }

}
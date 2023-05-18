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
    val scrollState = rememberScrollState()
    Box {
        Column(modifier = Modifier.verticalScroll(scrollState)) {

            Image(
                painter = painterResource(id = R.drawable.food),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(375.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = product.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                style = Theme.fonts.h4,
                color = Theme.colors.onSurfaceSecondary
            )
            Text(
                text = product.description,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                style = Theme.fonts.body1,
                color = Theme.colors.onSurfaceTernary
            )
            Spacer(modifier = Modifier.height(24.dp))
            fun measureUnitConcatenation(value: Any): String {
                return value.toString() + " ${product.measureUnit}"
            }

            val productAttrs = remember {
                listOf(
                    Pair("Вес", measureUnitConcatenation(product.measure)),
                    Pair("Энерг. ценность", "${product.energyPer100Grams} калл"),
                    Pair("Белки", measureUnitConcatenation(product.proteinsPer100Grams)),
                    Pair("Жиры", measureUnitConcatenation(product.fatsPer100Grams)),
                    Pair("Углеводы", measureUnitConcatenation(product.carbohydratesPer100Grams))
                )
            }
            productAttrs.forEach { param ->
                Divider(
                    color = Color(0x1F000000), modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                )
                FoodParamItem(name = param.first, value = param.second)
            }
            Divider(
                color = Color(0x1F000000), modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(93.dp))
        }
        BackArrow(onClick = { onSendEvent(ProductCardEvent.ClickedArrowBack) })
        BottomButton(onClick = { onSendEvent(ProductCardEvent.ClickedBuyButton) }) {
            Text(
                text = "В корзину за ${product.priceCurrent} ₽",
                color = Theme.colors.surface,
                style = Theme.fonts.button,
                maxLines = 1
            )
        }
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
package com.dashkevich.gourmets.ui.screens.catalog

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dashkevich.gourmets.ui.navigation.model.NavigationTree
import com.dashkevich.gourmets.ui.screens.catalog.companents.CatalogBottomSheet
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CatalogEvent
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CatalogState
import com.dashkevich.gourmets.ui.screens.catalog.companents.GourmetsTopBar
import com.dashkevich.gourmets.ui.screens.catalog.companents.CatalogButton
import com.dashkevich.gourmets.ui.screens.catalog.companents.CatalogFoodCard
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CatalogEffect
import kotlinx.coroutines.flow.Flow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen(
    viewState: CatalogState,
    effectFlow: Flow<CatalogEffect>?,
    onSendEvent: (event: CatalogEvent) -> Unit,
    navController: NavController,
) {
    val sheetState = rememberModalBottomSheetState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            GourmetsTopBar(
                categoriesTab = viewState.categoriesTab,
                onClickFilter = { onSendEvent(CatalogEvent.ClickedFilter) },
                selectedTab = viewState.selectedTab,
                onSelectedTab = {
                    onSendEvent(CatalogEvent.SelectedTab(it))
                })
        },
        bottomBar = {
            CatalogButton()
        }
    ) { scaffoldPadding ->
        Column(
            modifier = Modifier
                .padding(scaffoldPadding)
                .fillMaxSize()
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(top = 16.dp, bottom = 8.dp)
            ) {
                items(viewState.productList.size) { index ->

                    val product = viewState.productList[index]
                    val modifier =
                        if (index % 2 == 1) Modifier.padding(PaddingValues(start = 4.dp))
                        else Modifier.padding(PaddingValues(end = 4.dp))

                    val haveInBasket = viewState.productsBasket[product.id] != null
                    val count = viewState.productsBasket[product.id] ?: 0

                    CatalogFoodCard(
                        product = product,
                        modifier = modifier.padding(bottom = 8.dp),
                        onClick = {
                            Log.d("DebugCatalog", "onClick")
                            onSendEvent(CatalogEvent.ClickedFoodCard(it))
                        },
                        onButtonClick = {
                            onSendEvent(CatalogEvent.ClickedCardButton(it))
                        },
                        onMinusCounter = {
                            onSendEvent(CatalogEvent.ClickedMinusCounter(it))
                        },
                        haveInBasket = haveInBasket,
                        countInBasket = count
                    )
                }
            }
        }
        if (viewState.openBottomSheet) {
            CatalogBottomSheet(
                filters = viewState.filters,
                onCheckedClick = { index, newValue ->
                    onSendEvent(CatalogEvent.ClickedItemFilter(index, newValue))
                },
                onButtonClick = {
                    onSendEvent(CatalogEvent.ClickedButtonFilter())
                },
                onCloseBottomSheet = {
                    onSendEvent(CatalogEvent.CloseBottomSheet(it))
                },
                sheetState = sheetState
            )
        }

    }


    LaunchedEffect(key1 = Unit) {
        effectFlow?.collect { effect ->
            when (effect) {
                is CatalogEffect.NavigateToProductCard -> {
                    Log.d("DebugCatalog", "Navigate to Id product - " + effect.idProduct.toString())
                    navController.navigate(NavigationTree.Routes.PRODUCT_CARD + "/${effect.idProduct}")
                }
            }
        }
    }
}


package com.dashkevich.gourmets.ui.screens.catalog

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.dashkevich.gourmets.ui.screens.catalog.companents.CatalogBottomSheet
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CatalogEvent
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CatalogState
import com.dashkevich.gourmets.ui.screens.catalog.companents.GourmetsTopBar
import com.dashkevich.gourmets.ui.screens.catalog.companents.CatalogButton
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CatalogEffect
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach


@Composable
fun CatalogScreen(
    viewState: CatalogState,
    effectFlow: Flow<CatalogEffect>,
    onSendEvent: (event: CatalogEvent) -> Unit,
    navController: NavController,
) {
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
            }
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            GourmetsTopBar(
                categoriesTab = viewState.categoriesTab,
                onClickFilter = { onSendEvent(CatalogEvent.ClickedFilter) })
        },
        bottomBar = {
            CatalogButton()
        }
    ) { scaffoldPadding ->
        Column(modifier = Modifier.padding(scaffoldPadding)) {

        }
    }


    LaunchedEffect(key1 = Unit) {
        effectFlow.onEach { effect ->
            when (effect) {
                else -> {

                }
            }
        }
    }
}
package com.dashkevich.gourmets.ui.screens.catalog

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
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
    Scaffold(
        topBar = {
            GourmetsTopBar(categoriesTab = viewState.categoriesTab)
        },
        bottomBar = {
            CatalogButton()
        }
    ) { scaffoldPadding ->
        Column(modifier = Modifier.padding(scaffoldPadding)) {

        }
    }

    LaunchedEffect(key1 = Unit){
        effectFlow.onEach { effect ->
            when(effect){
                else -> {}
            }
        }
    }
}
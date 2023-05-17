package com.dashkevich.gourmets.ui.screens.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dashkevich.gourmets.ui.components.BottomButton
import com.dashkevich.gourmets.ui.screens.catalog.companents.FoodCard
import com.dashkevich.gourmets.ui.screens.catalog.model.FoodCatalog
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CatalogIntent
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CatalogState
import com.dashkevich.gourmets.ui.screens.catalog.companents.GourmetsTopBar
import com.dashkevich.gourmets.R
import com.dashkevich.gourmets.ui.screens.catalog.companents.CatalogButton
import com.dashkevich.gourmets.ui.theme.Theme


@Composable
fun CatalogScreen(
    viewState: CatalogState,
    processIntent: (CatalogIntent) -> Unit,
    navController: NavController
) {
    Scaffold(
        topBar = {
            GourmetsTopBar()
        },
        bottomBar = {
            CatalogButton()
        }
    ) { scaffoldPadding ->
        Column(modifier = Modifier.padding(scaffoldPadding)) {

        }
    }
}
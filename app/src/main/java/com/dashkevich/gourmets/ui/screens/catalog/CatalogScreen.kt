package com.dashkevich.gourmets.ui.screens.catalog

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dashkevich.gourmets.ui.screens.catalog.companents.GourmetsCategoryTabs
import com.dashkevich.gourmets.ui.screens.catalog.companents.GourmetsTopAppBar
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CatalogIntent
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CatalogState
import com.dashkevich.gourmets.ui.screens.catalog.companents.GourmetsTopBar


@Composable
fun CatalogScreen(
    viewState: CatalogState,
    processIntent: (CatalogIntent) -> Unit,
    navController: NavController
) {
    Scaffold(
        topBar = {
            GourmetsTopBar()
        }
    ) { scaffoldPadding ->
        Column(modifier = Modifier.padding(scaffoldPadding)) {
            Spacer(modifier = Modifier.height(8.dp))
            //Todo("Доделать tabs")
            //GourmetsCategoryTabs()


        }
    }
}
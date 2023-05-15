package com.dashkevich.gourmets.ui.screens.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dashkevich.gourmets.ui.screens.catalog.companents.GourmetsTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen() {
    Scaffold(
        topBar = {
            GourmetsTopAppBar()
        }
    ) {

    }
}
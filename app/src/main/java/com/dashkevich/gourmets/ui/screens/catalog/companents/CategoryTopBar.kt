package com.dashkevich.gourmets.ui.screens.catalog.companents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dashkevich.gourmets.R
import com.dashkevich.gourmets.ui.theme.Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GourmetsTopBar(modifier: Modifier = Modifier) {

    //Todo - фиксация топлайна при прокруте
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Theme.colors.surface)
            .shadow(elevation = 2.dp)
    ) {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Theme.colors.surface
            ),
            modifier = modifier
                .height(60.dp)
                .fillMaxWidth(),
            title = {
                GourmetsTopBarTitle()
            },
            navigationIcon = {
                Image(
                    painter = painterResource(id = R.drawable.icon_filter4x),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(PaddingValues(start = 20.dp, top = 28.dp))
                        .size(20.dp)
                )
            },
            actions = {
                Image(
                    painter = painterResource(id = R.drawable.icon_search4x),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(PaddingValues(end = 20.dp, top = 28.dp))
                        .size(20.dp)
                )
            },
        )
        @Composable
        fun spacer() = Spacer(
            modifier = Modifier
                .height(8.dp)
                .fillMaxWidth()
                .background(color = Theme.colors.surface)
        )
        spacer()
        CategoryTabs()
        spacer()
    }
}


@Composable
fun GourmetsTopBarTitle(modifier: Modifier = Modifier, paddingTop: Int = 16) {
    Image(
        painter = painterResource(id = R.drawable.icon_logo4x),
        contentDescription = null,
        modifier = modifier
            .padding(top = paddingTop.dp)
            .size(110.66.dp, 44.dp)
    )
}
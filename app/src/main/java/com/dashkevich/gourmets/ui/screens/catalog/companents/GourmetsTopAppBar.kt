package com.dashkevich.gourmets.ui.screens.catalog.companents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dashkevich.gourmets.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GourmetsTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        modifier = modifier.height(60.dp),
        title = {
            GourmetsTopAppBarTitle()
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
        }
    )
}


@Composable
fun GourmetsTopAppBarTitle(modifier: Modifier = Modifier, paddingTop: Int = 16) {
    Image(
        painter = painterResource(id = R.drawable.icon_logo4x),
        contentDescription = null,
        modifier = modifier
            .padding(top = paddingTop.dp)
            .size(110.66.dp, 44.dp)
    )
}
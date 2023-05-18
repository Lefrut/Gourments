package com.dashkevich.gourmets.ui.screens.catalog.companents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dashkevich.gourmets.R
import com.dashkevich.gourmets.common.OperationState
import com.dashkevich.gourmets.ui.components.ErrorText
import com.dashkevich.gourmets.ui.screens.catalog.model.mvi.CategoriesTab
import com.dashkevich.gourmets.ui.theme.Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GourmetsTopBar(modifier: Modifier = Modifier, categoriesTab: CategoriesTab, onClickFilter: () -> Unit) {

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
                        .clickable {
                            onClickFilter()
                        }
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
        Box(modifier = Modifier.height(40.dp).fillMaxWidth().background(color = Theme.colors.surface)) {
            when (categoriesTab.state) {
                OperationState.EmptyResult -> {
                    Text(
                        text = stringResource(R.string.не_одной_категории_не_найдено),
                        style = Theme.fonts.defaultRegularBody,
                        color = Theme.colors.onSurfaceSecondary,
                        modifier = modifier
                    )
                }
                OperationState.Success -> {
                    CategoryTabs(categoriesTab = categoriesTab)
                }
                OperationState.Error -> {
                    ErrorText(modifier = Modifier.align(Alignment.Center))
                }
                OperationState.Loading -> {
                    CircularProgressIndicator(
                        color = Theme.colors.primary,
                        modifier = Modifier
                            .align(
                                Alignment.Center
                            )
                            .size(30.dp)
                    )
                }
                OperationState.None -> {}
            }
        }
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
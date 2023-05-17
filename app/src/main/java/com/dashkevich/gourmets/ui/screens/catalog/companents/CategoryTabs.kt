package com.dashkevich.gourmets.ui.screens.catalog.companents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dashkevich.gourmets.ui.theme.GourmetsTheme
import com.dashkevich.gourmets.ui.theme.Theme
import com.dashkevich.gourmets.ui.util.ZeroCardElevation


@Composable
fun CategoryTabs() {
    var selectedCategory by remember { mutableStateOf(0) }
    val foodCategories = listOf("Роллы", "Наборы", "Горячие блюда", "Супы")

    ScrollableTabRow(
        modifier = Modifier.fillMaxWidth(),
        selectedTabIndex = selectedCategory,
        edgePadding = 16.dp,
        divider = { },
        indicator = { },
        containerColor = Theme.colors.surface
    ) {
        foodCategories.forEachIndexed { index, title ->
            val tabPadding = when (index) {
                0 -> {
                    PaddingValues(0.dp)
                }
                else -> {
                    PaddingValues(start = 8.dp)
                }
            }
            TabCategory(
                modifier = Modifier.padding(tabPadding),
                isSelected = selectedCategory == index,
                onClick = { selectedCategory = index },
                name = title
            )

        }
    }

}

@Composable
private fun TabCategory(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    onClick: () -> Unit,
    name: String,
) {
    val (cardColor, textColor) = if (isSelected)
        Pair(Theme.colors.primary, Theme.colors.surface)
    else
        Pair(Color.Transparent, Theme.colors.onSurfaceSecondary)
    Card(
        modifier = modifier
            .height(40.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(Theme.shapes.default),
        colors = CardDefaults.cardColors(
            containerColor = cardColor,
            disabledContainerColor = cardColor
        ),
        elevation = ZeroCardElevation()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxHeight()
        ) {
            Text(
                text = name, maxLines = 1,
                style = Theme.fonts.button, color = textColor,
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Start
            )
        }
    }
}

@Preview
@Composable
fun PreviewTabCategory() {
    GourmetsTheme() {
        TabCategory(isSelected = false, onClick = { }, name = "Запеченные роллы")
    }
}
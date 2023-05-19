package com.dashkevich.gourmets.ui.screens.product_card.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dashkevich.gourmets.ui.theme.Theme

@Composable
fun FoodParamItem(name: String, value: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(start = 16.dp),
            style = Theme.fonts.body1,
            color = Theme.colors.onSurfaceTernary
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = value,
            modifier = Modifier.padding(end = 16.dp),
            style = Theme.fonts.body1,
            color = Theme.colors.onSurfaceTernary
        )
    }
}
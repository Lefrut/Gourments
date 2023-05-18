package com.dashkevich.gourmets.ui.screens.catalog.companents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dashkevich.gourmets.ui.theme.Theme

@Composable
fun CatalogFilterItem(name: String, isChecked: Boolean, onCheckedClick: () -> Unit) {
    Column {
        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .height(48.dp)
                .fillMaxWidth()
                .clickable { onCheckedClick() },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = name,
                style = Theme.fonts.body1,
                color = Theme.colors.onSurfaceSecondary,
                modifier = Modifier
            )

            Checkbox(
                checked = isChecked,
                onCheckedChange = { onCheckedClick() },
                modifier = Modifier
                    .padding(end = 3.dp, start = 19.dp)
                    .size(18.dp)
            )
        }
        Divider(modifier = Modifier.fillMaxWidth().height(1.dp), color = Color(0x1F000000))
    }
}
package com.dashkevich.gourmets.ui.screens.catalog.companents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dashkevich.gourmets.R
import com.dashkevich.gourmets.ui.components.BottomButton
import com.dashkevich.gourmets.ui.theme.Theme

@Composable
fun CatalogButton() {
    //Todo - Доделать логику
    Box() {
        BottomButton(onClick = {}) {
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cart4x),
                    contentDescription = null,
                    modifier = Modifier.size(16.67.dp)
                )
                Spacer(modifier = Modifier.width(9.67.dp))
                Text(
                    text = "2160 ₽",
                    color = Theme.colors.surface,
                    style = Theme.fonts.button,
                    maxLines = 1
                )
            }
        }
    }
}
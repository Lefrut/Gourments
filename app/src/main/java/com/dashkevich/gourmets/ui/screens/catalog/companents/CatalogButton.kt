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
import com.dashkevich.gourmets.ui.util.ProductBasket

@Composable
fun CatalogButton(totalPrice: Int) {
    //Todo - Доделать логику
    Box() {
        BottomButton(onButtonClick = {}, haveInBasket = false, onMinusClick = {}) {
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

                    text = "$totalPrice ₽",
                    color = Theme.colors.surface,
                    style = Theme.fonts.button,
                    maxLines = 1
                )
            }
        }
    }
}
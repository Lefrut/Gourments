package com.dashkevich.gourmets.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dashkevich.gourmets.R
import com.dashkevich.gourmets.ui.theme.Theme
import com.dashkevich.gourmets.ui.util.shadow

@Composable
fun GourmetsCounter(
    modifier: Modifier,
    count: Int,
    minusIconSize: Size,
    plusIconSize: Size,
    counterContainerColor: Color,
    iconContainerSize: Size,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
    haveShadow: Boolean = false
) {
    Box(modifier = modifier) {
        Text(
            text = count.toString(), maxLines = 1,
            style = Theme.fonts.button, color = Theme.colors.onSurfaceSecondary,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )

        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
            fun Modifier.counterShadow() = if (haveShadow) shadow(
                color = Color(0x801F1F1F),
                offsetY = 4.dp,
                blurRadius = 16.dp,
                spread = (-10).dp
            ) else {
                shadow(0.dp)
            }
            IconButton(
                onClick = { onMinusClick() },
                modifier = Modifier
                    .counterShadow()
                    .size(iconContainerSize.width.dp, iconContainerSize.height.dp)
                    .background(color = counterContainerColor, shape = RoundedCornerShape(Theme.shapes.default)),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.minus), contentDescription = null,
                    modifier = Modifier.size(minusIconSize.width.dp, minusIconSize.height.dp),
                    tint = Theme.colors.primary

                )
            }
            IconButton(
                onClick = { onPlusClick() },
                modifier = Modifier
                    .counterShadow()
                    .size(iconContainerSize.width.dp, iconContainerSize.height.dp)
                    .background(color = counterContainerColor, shape = RoundedCornerShape(Theme.shapes.default))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.plus), contentDescription = null,
                    modifier = Modifier
                        .size(plusIconSize.width.dp, plusIconSize.height.dp),
                    tint = Theme.colors.primary
                )
            }
        }
    }
}
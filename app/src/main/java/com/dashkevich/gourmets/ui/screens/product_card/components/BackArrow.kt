package com.dashkevich.gourmets.ui.screens.product_card.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dashkevich.gourmets.R
import com.dashkevich.gourmets.ui.theme.Theme
import com.dashkevich.gourmets.ui.util.shadow

@Composable
fun BoxScope.BackArrow(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .align(Alignment.TopStart)
            .padding(top = 16.dp, start = 16.dp)
            .shadow(
                color = Color(0x801F1F1F),
                offsetX = 0.dp,
                offsetY = 4.dp,
                blurRadius = 16.dp,
                spread = (-10).dp
            )
            .size(44.dp)
            .clip(CircleShape)
            .background(color = Theme.colors.surface)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.arrow),
            contentDescription = null,
            modifier = Modifier.size(width = 20.dp, height = 16.dp)
        )
    }
}
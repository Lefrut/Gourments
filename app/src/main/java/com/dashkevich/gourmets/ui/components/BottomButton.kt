package com.dashkevich.gourmets.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dashkevich.gourmets.ui.components.PrimaryButton
import com.dashkevich.gourmets.ui.theme.Theme
import com.dashkevich.gourmets.ui.util.shadow

@Composable
fun BoxScope.BottomButton(onClick: () -> Unit, content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .shadow(
                offsetY = (-4).dp, blurRadius = 16.dp, spread = (-5).dp,
                color = Color(0x1A000000)
            )
            .fillMaxWidth()
            .height(72.dp)
            .background(color = Theme.colors.surface),
        contentAlignment = Alignment.Center
    ) {
        PrimaryButton(
            onClick = { onClick() },
            modifier = Modifier.size(width = 343.dp, height = 48.dp),
            content = {
                content()
            })
    }
}
package com.dashkevich.gourmets.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dashkevich.gourmets.ui.theme.Theme

@Composable
fun PrimaryButton(onClick: () -> Unit, content: @Composable RowScope.() -> Unit) {
    Button(
        modifier = Modifier.fillMaxSize().padding(PaddingValues(horizontal = 16.dp, vertical = 12.dp)),
        onClick = {
            onClick()
        },
        shape = RoundedCornerShape(Theme.shapes.default),
        colors = ButtonDefaults.buttonColors(
            containerColor = Theme.colors.primary
        )
    ) {
        content()
    }
}
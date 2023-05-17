package com.dashkevich.gourmets.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.dashkevich.gourmets.R
import com.dashkevich.gourmets.ui.theme.Theme

@Composable
fun ErrorText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.Ошибка_получения_данный),
        style = Theme.fonts.h4,
        color = Color.Red,
        modifier = modifier
    )
}
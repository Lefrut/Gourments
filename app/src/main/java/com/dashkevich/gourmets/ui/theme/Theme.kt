package com.dashkevich.gourmets.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.dashkevich.gourmets.ui.theme.model.GourmetsColorScheme
import com.dashkevich.gourmets.ui.theme.model.GourmetsShape
import com.dashkevich.gourmets.ui.theme.model.GourmetsTypography

private val DarkColorScheme = GourmetsColorScheme(
    primary = primary_light,
    background = background_light,
    surface = surface_light,
    onSurfacePrimary = onSurfacePrimary_light,
    onSurfaceSecondary = onSurfaceSecondary_light,
    onSurfaceTernary = onSurfaceTernary_light,
)

private val LightColorScheme = GourmetsColorScheme(
    primary = primary_light,
    background = background_light,
    surface = surface_light,
    onSurfacePrimary = onSurfacePrimary_light,
    onSurfaceSecondary = onSurfaceSecondary_light,
    onSurfaceTernary = onSurfaceTernary_light,
)

@Composable
fun GourmentsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            with((view.context as Activity).window) {
                statusBarColor = colorScheme.primary.toArgb()
                navigationBarColor = colorScheme.primary.toArgb()
            }
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightNavigationBars = darkTheme
        }
    }
    CompositionLocalProvider(
        LocalColorProvider provides colorScheme,
        LocalShapeProvider provides GourmetsShape,
        LocalTypographyProvider provides GourmetsTypography,
        content = content
    )
}

object Theme {
    val colors: GourmetsColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColorProvider.current

    val shapes: GourmetsShape
        @Composable
        @ReadOnlyComposable
        get() = LocalShapeProvider.current

    val fonts: GourmetsTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypographyProvider.current
}

val LocalColorProvider = staticCompositionLocalOf<GourmetsColorScheme> {
    error("No colors")
}

val LocalShapeProvider = staticCompositionLocalOf<GourmetsShape> {
    error("No shapes")
}

val LocalTypographyProvider = staticCompositionLocalOf<GourmetsTypography> {
    error("No fonts")
}


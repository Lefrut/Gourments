package com.dashkevich.gourments.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.dashkevich.gourments.ui.theme.model.GourmentsColorScheme
import com.dashkevich.gourments.ui.theme.model.GourmentsShape
import com.dashkevich.gourments.ui.theme.model.GourmentsTypography

private val DarkColorScheme = GourmentsColorScheme(
    primary = primary_light,
    background = background_light,
    surface = surface_light,
    onSurfacePrimary = onSurfacePrimary_light,
    onSurfaceSecondary = onSurfaceSecondary_light,
    onSurfaceTernary = onSurfaceTernary_light,
)

private val LightColorScheme = GourmentsColorScheme(
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
        LocalShapeProvider provides GourmentsShape,
        LocalTypographyProvider provides GourmentsTypography,
        content = content
    )
}

object Theme {
    val colors: GourmentsColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColorProvider.current

    val shapes: GourmentsShape
        @Composable
        @ReadOnlyComposable
        get() = LocalShapeProvider.current

    val fonts: GourmentsTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypographyProvider.current
}

val LocalColorProvider = staticCompositionLocalOf<GourmentsColorScheme> {
    error("No colors")
}

val LocalShapeProvider = staticCompositionLocalOf<GourmentsShape> {
    error("No shapes")
}

val LocalTypographyProvider = staticCompositionLocalOf<GourmentsTypography> {
    error("No fonts")
}


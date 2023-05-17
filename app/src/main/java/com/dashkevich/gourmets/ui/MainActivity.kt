package com.dashkevich.gourmets.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.dashkevich.gourmets.ui.navigation.AppNavigation
import com.dashkevich.gourmets.ui.theme.GourmetsTheme
import com.dashkevich.gourmets.ui.theme.Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GourmetsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Theme.colors.surface
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

package com.dashkevich.gourmets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dashkevich.gourmets.ui.navigation.AppNavigation
import com.dashkevich.gourmets.ui.theme.GourmentsTheme
import com.dashkevich.gourmets.ui.theme.Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GourmentsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Theme.colors.surface
                ) {
                }
            }
        }
    }
}
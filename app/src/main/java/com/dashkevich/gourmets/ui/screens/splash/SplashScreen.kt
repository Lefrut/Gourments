package com.dashkevich.gourmets.ui.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.dashkevich.gourmets.R
import com.dashkevich.gourmets.ui.navigation.model.NavigationTree

@Composable
fun SplashScreen(navController: NavController) {
    val composite by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.animation)
    )

    val progress by animateLottieCompositionAsState(composite)

    Box(modifier = Modifier.fillMaxSize()) {
        LottieAnimation(composition = composite, progress = progress)
    }

    LaunchedEffect(key1 = progress){
        if(progress>=1f) {
            navController.navigate(NavigationTree.Routes.CATALOG) {
                navController.popBackStack()
            }
        }
    }

}
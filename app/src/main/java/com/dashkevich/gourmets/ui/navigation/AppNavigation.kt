package com.dashkevich.gourmets.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dashkevich.gourmets.ui.navigation.destinations.CatalogScreenDestination
import com.dashkevich.gourmets.ui.navigation.model.NavigationTree

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationTree.Routes.CATALOG){
        composable(route = NavigationTree.Routes.CATALOG){
            CatalogScreenDestination(navController = navController)
        }
    }

}
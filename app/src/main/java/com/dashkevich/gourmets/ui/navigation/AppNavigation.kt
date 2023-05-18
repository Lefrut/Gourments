package com.dashkevich.gourmets.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dashkevich.gourmets.ui.navigation.destinations.CatalogScreenDestination
import com.dashkevich.gourmets.ui.navigation.destinations.ProductCardScreenDestination
import com.dashkevich.gourmets.ui.navigation.model.NavigationTree
import com.dashkevich.gourmets.ui.util.productExample
import com.dashkevich.gourmets.ui.util.productJsonExample
import com.google.gson.Gson

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationTree.Routes.CATALOG
    ) {

        composable(route = NavigationTree.Routes.CATALOG) {
            CatalogScreenDestination(navController = navController)
        }
        composable(
            route = NavigationTree.Routes.PRODUCT_CARD + "/{${NavigationTree.Args.PRODUCT}}",
            arguments = listOf(navArgument(NavigationTree.Args.PRODUCT) {
                type = NavType.StringType
            })
        ) { it ->
            it.arguments?.getString(NavigationTree.Args.PRODUCT)?.let { json ->
                ProductCardScreenDestination(
                    navController = navController,
                    productJson = json
                )

            }
        }

    }
}
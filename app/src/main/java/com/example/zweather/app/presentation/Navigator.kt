package com.example.zweather.app.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zweather.app.presentation.screens.home.HomeScreen
import com.example.zweather.app.presentation.screens.search.SearchScreen
import com.example.zweather.app.presentation.screens.splash.SplashScreen

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Search : Screen("search")
}

@Composable
fun Navigator() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(onSplashCompleted = {
                navController.navigate(Screen.Home.route) {
                    // Remove Splash from back stack
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            })
        }

        composable(route = Screen.Home.route) {
            HomeScreen()
        }
        composable(route = Screen.Search.route) {
            SearchScreen()
        }
    }
}
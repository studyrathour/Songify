package com.songify.app.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.songify.app.ui.screens.HomeScreen
import com.songify.app.ui.screens.PlayerScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onNavigateToPlayer = { navController.navigate("player") })
        }
        composable("player") {
            PlayerScreen()
        }
    }
}

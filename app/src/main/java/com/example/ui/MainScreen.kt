package com.example.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation.Routes
import com.example.ui.screens.auth.LoginScreen
import com.example.ui.screens.topup.GameTopUpScreen
import com.example.ui.screens.topup.PulsaTopUpScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Login) {
        composable(Routes.Login) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.Main) {
                        popUpTo(Routes.Login) { inclusive = true }
                    }
                }
            )
        }
        composable(Routes.Main) {
            DashboardScreen(mainNavController = navController)
        }
        composable("topup_game/{gameName}") { backStackEntry ->
            GameTopUpScreen(onBack = { navController.popBackStack() })
        }
        composable(Routes.PulsaTopUp) {
            PulsaTopUpScreen(onBack = { navController.popBackStack() })
        }
    }
}

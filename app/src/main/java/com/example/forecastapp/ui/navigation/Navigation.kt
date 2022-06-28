package com.example.forecastapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.forecastapp.ui.forecast_list.ForecastListScreen
import com.example.forecastapp.util.Constants

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.ForecastListScreen.route
    ) {
        composable(route = Screen.ForecastListScreen.route) {
            ForecastListScreen(navController = navController)
        }
    }
}
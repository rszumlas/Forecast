package com.example.forecastapp.ui.navigation

import com.example.forecastapp.util.Constants

sealed class Screen(val route: String) {
    object ForecastListScreen : Screen(Constants.FORECAST_LIST_SCREEN)
}
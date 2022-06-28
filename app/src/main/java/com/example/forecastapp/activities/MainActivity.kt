package com.example.forecastapp.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.forecastapp.ui.navigation.Screen
import com.example.forecastapp.ui.forecast_list.ForecastListScreen
import com.example.forecastapp.ui.navigation.Navigation
import com.example.forecastapp.ui.theme.ForecastAppTheme
import com.example.forecastapp.util.Constants
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForecastAppTheme {
                Navigation()
            }
        }
    }
}

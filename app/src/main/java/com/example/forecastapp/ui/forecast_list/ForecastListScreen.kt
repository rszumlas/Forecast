package com.example.forecastapp.ui.forecast_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.forecastapp.viewmodels.MainActivityViewModel

@Composable
fun ForecastListScreen (
    navController: NavController,
    viewmodel: MainActivityViewModel = hiltViewModel()
) {
    val forecasts = viewmodel.forecasts.collectAsState(initial = emptyList())
    val scaffoldState = rememberScaffoldState()

    Scaffold (
        scaffoldState = scaffoldState,
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(forecasts.value) { forecastData ->
                forecastItem(
                    forecastData = forecastData,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }

}
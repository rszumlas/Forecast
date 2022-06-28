package com.example.forecastapp.ui.forecast_list

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.forecastapp.data.db.ForecastData
import androidx.compose.ui.Modifier


@Composable
fun forecastItem(
    forecastData: ForecastData,
    modifier: Modifier = Modifier
) {
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column (
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = forecastData.stacja,
                fontSize = 30.sp,
//                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Ciśnienie: ${forecastData.cisnienie.toString()} hPa",
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Wilgotność: ${forecastData.wilgotnosc_wzgledna.toString()}%",
                fontSize = 13.sp
            )
        }
        Text(
            text = forecastData.temperatura.toString(),
            fontSize = 40.sp,
//            fontWeight = FontWeight.Bold
        )

    }

}




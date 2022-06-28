package com.example.forecastapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "forecast_table")
data class ForecastData(
    @PrimaryKey
    val id_stacji: Int,
    val stacja: String,
    val temperatura: Float,
    val wilgotnosc_wzgledna: Float,
    val cisnienie: Float
)
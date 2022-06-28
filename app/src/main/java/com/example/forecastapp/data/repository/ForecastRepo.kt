package com.example.forecastapp.data.repository

import androidx.lifecycle.LiveData
import com.example.forecastapp.data.db.ForecastData
import retrofit2.Response
import kotlinx.coroutines.flow.Flow

interface ForecastRepo {

    // API
    suspend fun getRecord(station: String): Response<ForecastData>


    // ROOM
    suspend fun insertRecord(forecastData: ForecastData)

    fun getAllRecords(): LiveData<List<ForecastData>>

}
package com.example.forecastapp.data.api

import com.example.forecastapp.data.db.ForecastData
import com.example.forecastapp.util.Constants
import com.example.forecastapp.util.Constants.GDANSK
import com.example.forecastapp.util.Constants.KRAKOW
import com.example.forecastapp.util.Constants.TORUN
import com.example.forecastapp.util.Constants.WARSZAWA
import com.example.forecastapp.util.Constants.WROCLAW
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET(WARSZAWA)
    suspend fun getWarsawRecord(): Response<ForecastData>

    @GET(KRAKOW)
    suspend fun getKrakowRecord(): Response<ForecastData>

    @GET(GDANSK)
    suspend fun getGdanskRecord(): Response<ForecastData>

    @GET(TORUN)
    suspend fun getTorunRecord(): Response<ForecastData>

    @GET(WROCLAW)
    suspend fun getWroclawRecord(): Response<ForecastData>

}
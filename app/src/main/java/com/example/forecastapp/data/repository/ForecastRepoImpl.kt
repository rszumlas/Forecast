package com.example.forecastapp.data.repository

import androidx.lifecycle.LiveData
import com.example.forecastapp.data.api.Api
import com.example.forecastapp.data.db.Dao
import com.example.forecastapp.data.db.ForecastData
import com.example.forecastapp.util.Constants
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class ForecastRepoImpl @Inject constructor(
    private val api: Api,
    private val dao: Dao
): ForecastRepo {

    // API
    override suspend fun getRecord(station: String): Response<ForecastData> {
        val response = when(station) {
            Constants.WARSZAWA -> api.getWarsawRecord()
            Constants.KRAKOW -> api.getKrakowRecord()
            Constants.GDANSK -> api.getGdanskRecord()
            Constants.TORUN -> api.getTorunRecord()
            Constants.WROCLAW -> api.getWroclawRecord()
            else -> {api.getWarsawRecord()}
        }
        if (response.isSuccessful && response.body() != null) {
            this.insertRecord(response.body()!!)
        }
        return response
    }

    // ROOM
    override suspend fun insertRecord(forecastData: ForecastData) {
        dao.insertRecord(forecastData)
    }

    override fun getAllRecords(): LiveData<List<ForecastData>> =
        dao.getAllRecords()

}
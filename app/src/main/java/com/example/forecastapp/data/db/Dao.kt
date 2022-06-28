package com.example.forecastapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecord(forecastData: ForecastData)

    @Query("SELECT * FROM forecast_table")
    fun getAllRecords(): LiveData<List<ForecastData>>
}
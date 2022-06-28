package com.example.forecastapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ForecastData::class],
    version = 1
)

abstract class Database: RoomDatabase() {

    abstract fun dao(): Dao

}
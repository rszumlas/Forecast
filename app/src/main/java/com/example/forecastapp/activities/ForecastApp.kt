package com.example.forecastapp.activities

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ForecastApp : Application()

@HiltAndroidApp(MultiDexApplication::class)
class MyApplication : Hilt_MyApplication()
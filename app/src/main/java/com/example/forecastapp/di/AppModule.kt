package com.example.forecastapp.di

import android.app.Application
import androidx.room.Room
import com.example.forecastapp.data.api.Api
import com.example.forecastapp.data.db.Dao
import com.example.forecastapp.data.db.Database
import com.example.forecastapp.data.repository.ForecastRepo
import com.example.forecastapp.data.repository.ForecastRepoImpl
import com.example.forecastapp.util.Constants
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // RETROFIT
    @Singleton
    @Provides
    fun provideRetrofitInstance(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    @Provides
    fun provideForecastApi(retrofit: Retrofit): Api =
        retrofit.create(Api::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(30L, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()

    // ROOM
    @Provides
    @Singleton
    fun provideForecastDB(application: Application) = Room.databaseBuilder(
        application,
        Database::class.java,
        "forecast_db"
    ).build()

    @Provides
    @Singleton
    fun provideDao(db: Database): Dao = db.dao()

    @Provides
    @Singleton
    fun provideForecastRepo(api: Api, db: Database): ForecastRepo =
        ForecastRepoImpl(api, db.dao())



}
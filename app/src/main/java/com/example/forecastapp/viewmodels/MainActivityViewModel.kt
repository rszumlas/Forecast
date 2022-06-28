package com.example.forecastapp.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forecastapp.data.repository.ForecastRepo
import com.example.forecastapp.util.Constants
import com.example.forecastapp.util.Constants.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: ForecastRepo
): ViewModel() {

    val forecasts = repository.getAllRecords()

    init {
        makeCompleteCall()
    }

    fun makeCompleteCall() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                makeApiCalls(repository)
            } catch (e: IOException) {
                Log.e(TAG, "IOException - you might not have internet connection")
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException - unexpected response")
            } catch (e: Exception) {
                Log.e(TAG, "Exception - something went wrong")
            }
        }
    }

    suspend fun makeApiCalls(repository: ForecastRepo) {
        repository.getRecord(Constants.WARSZAWA)
        repository.getRecord(Constants.KRAKOW)
        repository.getRecord(Constants.GDANSK)
        repository.getRecord(Constants.TORUN)
        repository.getRecord(Constants.WROCLAW)
    }

}
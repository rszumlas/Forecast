//package com.example.forecastapp.data.db
//
//import androidx.room.Room
//import androidx.test.core.app.ApplicationProvider
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import androidx.test.filters.SmallTest
//import com.example.forecastapp.getOrAwaitValue
//import com.google.common.truth.Truth.assertThat
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.test.runBlockingTest
//import org.junit.After
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//
//@ExperimentalCoroutinesApi
//@RunWith(AndroidJUnit4::class)
//@SmallTest
//class DaoTest {
//
//    private lateinit var db: Database
//    private lateinit var dao: Dao
//
//    @Before
//    fun setup() {
//        db = Room.inMemoryDatabaseBuilder(
//            ApplicationProvider.getApplicationContext(),
//            Database::class.java
//        ).allowMainThreadQueries().build()
//        dao = db.dao()
//    }
//
//    @After
//    fun teardown() {
//        db.close()
//    }
//
//    @Test
//    fun insertForecastData() = runBlockingTest {
//        val forecastData = ForecastData(12512, "miasto", 30f, 67f, 1014f)
//        dao.insertRecord(forecastData)
//
//        val allRecords = dao.getAllRecords()
//        assertThat(allRecords.contains(forecastData)).isTrue()
//    }
//}
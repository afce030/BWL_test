package com.example.bwl_test.Model.LocalData.RoomDAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bwl_test.Model.LocalData.RoomEntities.WeatherEntity

@Dao
interface WeatherDAO {

    //Functions for Api data
    @Query("SELECT * from weather_table ORDER BY name ASC")
    suspend fun getAllWeathersFromRoom(): List<WeatherEntity>

    @Query("SELECT * from weather_table WHERE name=:nombre")
    suspend fun getWeatherFromRoom(nombre: String): WeatherEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertweather(weatherEntity: WeatherEntity)

    @Query("DELETE FROM weather_table")
    suspend fun deleteAllweather()

}
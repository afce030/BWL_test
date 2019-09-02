package com.example.bwl_test.Model.LocalData.RoomDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bwl_test.Model.LocalData.RoomDAO.PlacesDAO
import com.example.bwl_test.Model.LocalData.RoomDAO.WeatherDAO
import com.example.bwl_test.Model.LocalData.RoomEntities.PlacesEntity
import com.example.bwl_test.Model.LocalData.RoomEntities.WeatherEntity

@Database(entities = [PlacesEntity::class, WeatherEntity::class], version = 1, exportSchema = false)
abstract class PlacesDatabase: RoomDatabase() {

    abstract fun placesDAO(): PlacesDAO
    abstract fun weatherDAO(): WeatherDAO

}

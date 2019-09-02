package com.example.bwl_test.Model.LocalData.RoomEntities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Weather_table")
data class WeatherEntity (

    @PrimaryKey
    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "lat")
    var lat: String = "",

    @ColumnInfo(name = "lng")
    var lng: String = "",

    @ColumnInfo(name = "tempC")
    val tempC: Int? = null

)
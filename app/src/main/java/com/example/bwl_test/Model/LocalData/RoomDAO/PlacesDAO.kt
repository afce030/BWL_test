package com.example.bwl_test.Model.LocalData.RoomDAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bwl_test.Model.LocalData.RoomEntities.PlacesEntity

@Dao
interface PlacesDAO {

    //Functions for Json data
    @Query("SELECT * from places_table ORDER BY name ASC")
    suspend fun getAllPlacesFromRoom(): List<PlacesEntity>

    @Query("SELECT * from places_table WHERE name=:nombre")
    suspend fun getPlaceFromRoom(nombre: String): PlacesEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(placesEntity: List<PlacesEntity>)

    @Query("DELETE FROM places_table")
    suspend fun deleteAll()

}
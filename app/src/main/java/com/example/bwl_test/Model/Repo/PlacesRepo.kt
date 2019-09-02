package com.example.bwl_test.Model.Repo

import android.content.Context
import com.example.bwl_test.Model.DTOelements.PlaceDTO
import com.example.bwl_test.Model.LocalData.RoomDatabase.PlacesDatabase
import com.example.bwl_test.Model.LocalData.RoomEntities.PlacesEntity
import com.example.bwl_test.myApp
import com.google.gson.Gson
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import java.io.IOException
import javax.inject.Inject

class PlacesRepo @Inject constructor(app: myApp, gson: Gson, placesDatabase: PlacesDatabase) {

    val context: Context = app.applicationContext
    val placesDAO = placesDatabase.placesDAO()
    val gson = gson

    init {
        refreshPlaces()
    }

    fun refreshPlaces(){
        val json = getJsonFile("places_default.json")
        val placesDTO = gson.fromJson(json, Array<PlaceDTO>::class.java)
        val placesList: List<PlaceDTO> = placesDTO.toList()

        val placesEntity : MutableList<PlacesEntity> = mutableListOf()
        for (placeDTO in placesList) {
            placesEntity.add( PlacesEntity(placeDTO.name!!,placeDTO.lat!!,placeDTO.lng!!) )
        }

        CoroutineScope(Dispatchers.IO).launch {
            insertPlaces(placesEntity)
        }
    }

    suspend fun getPlaces() = withContext(Dispatchers.IO){
        placesDAO.getAllPlacesFromRoom()
    }

    suspend fun insertPlaces(placesEntity: List<PlacesEntity>){
        placesDAO.insertAll(placesEntity)
    }

    fun getJsonFile(file: String): String? {
        var json: String? = null
        try {
            val inputStream = context.assets.open(file)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
        }

        return json
    }

}
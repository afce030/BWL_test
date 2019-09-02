package com.example.bwl_test.Model.Repo

import android.util.Log
import com.example.bwl_test.Model.DTOelements.CityWeatherDTO
import com.example.bwl_test.Model.LocalData.RoomDatabase.PlacesDatabase
import com.example.bwl_test.Model.LocalData.RoomEntities.WeatherEntity
import com.example.bwl_test.Model.Retrofit.WeatherWS
import com.example.bwl_test.Util.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WeatherRepo @Inject constructor(val weatherWS: WeatherWS, placesDatabase: PlacesDatabase) {

    val weatherDAO = placesDatabase.weatherDAO()

    init {
        for(i in 0..1) {
            refreshWeathers(Constants.CITIES[i])
        }
    }

    fun refreshWeathers(city: String){

        val call = weatherWS.getWeatherFromAPI(Constants.API_KEY, city)
        call.enqueue(object : Callback<CityWeatherDTO> {
            override fun onResponse(call: Call<CityWeatherDTO>, response: Response<CityWeatherDTO>) {

                if(response.isSuccessful){

                    val weatherDTO = response.body()!!

                    val weatherEntity = WeatherEntity(
                        weatherDTO.location?.name!!,
                        weatherDTO.location.lat.toString(),
                        weatherDTO.location.lon.toString(),
                        weatherDTO.current?.tempC)

                    CoroutineScope(Dispatchers.IO).launch {
                        insertWeathers(weatherEntity)
                    }
                }
            }
            override fun onFailure(call: Call<CityWeatherDTO>, t: Throwable) {
            }
        })
    }

    suspend fun getWeathers() = withContext(Dispatchers.IO){
        weatherDAO.getAllWeathersFromRoom()
    }

    suspend fun insertWeathers(weatherEntity: WeatherEntity){
        weatherDAO.insertweather(weatherEntity)
    }

}
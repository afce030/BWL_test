package com.example.bwl_test.Model.Retrofit

import com.example.bwl_test.Model.DTOelements.CityWeatherDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/*
* Query example: http://api.apixu.com/v1/current.json?key=1f5e6cf353fc4a7d9b832718190209&q=Paris
* */

interface WeatherWS {

    @GET("current.json")
    fun getWeatherFromAPI(
        @Query("key") key: String,
        @Query("q") city: String): Call<CityWeatherDTO>

}
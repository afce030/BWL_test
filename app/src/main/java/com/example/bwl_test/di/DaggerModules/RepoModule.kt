package com.example.bwl_test.di.DaggerModules

import androidx.room.Room
import com.example.bwl_test.Model.LocalData.RoomDatabase.PlacesDatabase
import com.example.bwl_test.Model.Repo.PlacesRepo
import com.example.bwl_test.Model.Repo.WeatherRepo
import com.example.bwl_test.Model.Retrofit.WeatherWS
import com.example.bwl_test.myApp
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun providesGson(): Gson = Gson()

    @Singleton
    @Provides
    fun providesDatabase(application: myApp): PlacesDatabase{
        return Room.databaseBuilder(application.applicationContext,
            PlacesDatabase::class.java, "PlacesDB").build()
    }

    @Singleton
    @Provides
    fun providesPlacesRepo(application: myApp, gson: Gson, placesDatabase: PlacesDatabase): PlacesRepo{
        return PlacesRepo(application, gson, placesDatabase)
    }

    @Singleton
    @Provides
    fun providesWeatherRepo(weatherWS: WeatherWS, placesDatabase: PlacesDatabase): WeatherRepo {
        return WeatherRepo(weatherWS, placesDatabase)
    }


}
package com.example.bwl_test.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bwl_test.Model.LocalData.RoomEntities.WeatherEntity
import com.example.bwl_test.Model.Repo.WeatherRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherViewModel @Inject constructor(private val weatherRepo: WeatherRepo) : ViewModel() {

    var weathers: MutableLiveData<List<WeatherEntity>> = MutableLiveData()

    fun getWeathersFromVM(): LiveData<List<WeatherEntity>> {
        viewModelScope.launch {
            weathers.value = weatherRepo.getWeathers()
            Log.d(weathers.value!!.size.toString(),"wwwwwwww")
        }
        return weathers
    }

}
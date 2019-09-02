package com.example.bwl_test.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bwl_test.Model.LocalData.RoomEntities.PlacesEntity
import com.example.bwl_test.Model.Repo.PlacesRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlacesViewModel @Inject constructor(private val placesRepo: PlacesRepo) : ViewModel() {

    var places: MutableLiveData<List<PlacesEntity>> = MutableLiveData()

    fun getPlacesFromVM(): LiveData<List<PlacesEntity>> {
        viewModelScope.launch {
            places.value = placesRepo.getPlaces()
        }
        return places
    }

}
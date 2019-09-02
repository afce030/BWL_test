package com.example.bwl_test.di.DaggerModules.ViewModelBuilders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bwl_test.ViewModels.PlacesViewModel
import com.example.bwl_test.ViewModels.WeatherViewModel
import com.example.bwl_test.di.Factory.ViewModelFactory
import com.example.bwl_test.di.Factory.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule{

    @Binds
    @IntoMap
    @ViewModelKey(PlacesViewModel::class)
    abstract fun bindPlacesViewModel(placesViewModel: PlacesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel::class)
    abstract fun bindWeatherViewModel(weatherViewModel: WeatherViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
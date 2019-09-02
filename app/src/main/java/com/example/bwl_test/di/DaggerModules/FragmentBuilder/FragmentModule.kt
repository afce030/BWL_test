package com.example.bwl_test.di.DaggerModules.FragmentBuilder

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.bwl_test.View.Fragments.MapFragment
import com.example.bwl_test.View.Fragments.PlacesFragment
import com.example.bwl_test.View.Fragments.WeatherFragment
import com.example.bwl_test.di.Factory.FragmentKey
import com.example.bwl_test.di.Factory.injFragmentFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(PlacesFragment::class)
    abstract fun bindPlacesFragment(placesFragment: PlacesFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(MapFragment::class)
    abstract fun bindMapFragment(mapFragment: MapFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(WeatherFragment::class)
    abstract fun bindWeatherFragment(weatherFragment: WeatherFragment): Fragment

    @Binds
    abstract fun bindFragmentFactory(factory: injFragmentFactory): FragmentFactory
}
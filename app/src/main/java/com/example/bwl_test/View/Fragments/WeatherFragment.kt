package com.example.bwl_test.View.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.bwl_test.R
import com.example.bwl_test.View.Adapters.WeatherAdapter
import com.example.bwl_test.ViewModels.WeatherViewModel
import javax.inject.Inject

class WeatherFragment @Inject constructor() : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_weather, container, false)
        val vm = ViewModelProvider(this, viewModelFactory)[WeatherViewModel::class.java]

        val recycler = view.findViewById<RecyclerView>(R.id.rvWeather)
        val adapter = WeatherAdapter(ArrayList(), view)

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)

        vm.getWeathersFromVM().observe(this, Observer {
            adapter.ModifyELements(it)
        })

        return view
    }


}

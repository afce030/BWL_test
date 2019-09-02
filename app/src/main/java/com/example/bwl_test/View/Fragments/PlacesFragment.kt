package com.example.bwl_test.View.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bwl_test.View.Adapters.PlacesAdapter
import com.example.bwl_test.R
import com.example.bwl_test.ViewModels.PlacesViewModel
import javax.inject.Inject
import kotlin.collections.ArrayList

class PlacesFragment @Inject constructor() : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_places, container, false)
        val vm = ViewModelProvider(this, viewModelFactory)[PlacesViewModel::class.java]

        val verClima = view.findViewById<Button>(R.id.btnVerClima)

        verClima.setOnClickListener {
            val action = PlacesFragmentDirections.actionPlacesFragmentToWeatherFragment()
            view.findNavController().navigate(action)
        }

        val recycler = view.findViewById<RecyclerView>(R.id.rvPlaces)
        val adapter = PlacesAdapter(ArrayList(), view)

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)

        vm.getPlacesFromVM().observe(this, Observer {
            adapter.ModifyELements(it)
        })

        return view
    }

}

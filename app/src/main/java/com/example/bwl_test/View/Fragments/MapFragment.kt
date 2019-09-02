package com.example.bwl_test.View.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bwl_test.Model.LocalData.RoomEntities.PlacesEntity

import com.example.bwl_test.R
import com.example.bwl_test.View.Adapters.PlacesAdapter
import com.example.bwl_test.ViewModels.PlacesViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import javax.inject.Inject

class MapFragment @Inject constructor() : Fragment(), OnMapReadyCallback {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mMap: GoogleMap
    val args: MapFragmentArgs by navArgs()

    var locations: MutableList<PlacesEntity> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        val mapF = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        val vm = ViewModelProvider(this, viewModelFactory)[PlacesViewModel::class.java]

        if(args.argPlaceName.equals("NoPlace")) {
            vm.getPlacesFromVM().observe(this, Observer {
                locations.addAll(it)
                mapF.getMapAsync(this)
            })
        }else{
            mapF.getMapAsync(this)
        }

        return view
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        if(args.argPlaceName.equals("NoPlace")) {
            for(place in locations){
                val coordenadas = LatLng(place.lat.toDouble(), place.lng.toDouble())
                mMap.addMarker(MarkerOptions().position(coordenadas))
            }
            val coordenadas = LatLng(8.9935999, -79.5197296)
            mMap.moveCamera(CameraUpdateFactory.newLatLng(coordenadas))
        }else{
            val coordenadas = LatLng(args.argLat.toDouble(), args.argLng.toDouble())
            mMap.addMarker(MarkerOptions().position(coordenadas))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(coordenadas))
        }

    }

}

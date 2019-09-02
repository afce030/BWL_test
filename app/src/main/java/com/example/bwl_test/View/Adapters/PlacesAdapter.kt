package com.example.bwl_test.View.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bwl_test.Model.LocalData.RoomEntities.PlacesEntity
import com.example.bwl_test.View.Fragments.PlacesFragmentDirections
import com.example.bwl_test.R
import com.example.bwl_test.View.ViewHolders.PlacesViewHolder
import kotlinx.android.synthetic.main.place_item.view.*

class PlacesAdapter(var places: MutableList<PlacesEntity>, val viewFrag : View) : RecyclerView.Adapter<PlacesViewHolder>() {

    fun ModifyELements(places: List<PlacesEntity>){
        this.places = ArrayList()
        this.places.addAll(places)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item, parent, false)
        return PlacesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return places.size
    }

    override fun onBindViewHolder(holder: PlacesViewHolder, position: Int) {
        holder.itemView.tvPlaceAdapterPlaces.text = places[position].name
        holder.itemView.tvLatAdapterPlaces.text = places[position].lat
        holder.itemView.tvLongAdapterPlaces.text = places[position].lng

        holder.itemView.setOnClickListener {
            val action = PlacesFragmentDirections.actionPlacesFragmentToMapFragment(
                places[position].name,
                places[position].lat,
                places[position].lng)
            viewFrag.findNavController().navigate(action)
        }
    }
}
package com.example.bwl_test.View.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bwl_test.Model.LocalData.RoomEntities.WeatherEntity
import com.example.bwl_test.R
import com.example.bwl_test.View.Fragments.WeatherFragmentDirections
import com.example.bwl_test.View.ViewHolders.WeatherViewHolder
import kotlinx.android.synthetic.main.weather_item.view.*


class WeatherAdapter(var weathers: MutableList<WeatherEntity>, val viewFrag : View) : RecyclerView.Adapter<WeatherViewHolder>() {

    fun ModifyELements(weathers: List<WeatherEntity>){
        this.weathers = ArrayList()
        this.weathers.addAll(weathers)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weather_item, parent, false)
        return WeatherViewHolder(view)
    }

    override fun getItemCount(): Int {
        return weathers.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.itemView.tvPlaceAdapterWeather.text = weathers[position].name
        holder.itemView.tvLatAdapterWeather.text = weathers[position].lat
        holder.itemView.tvLongAdapterWeather.text = weathers[position].lng
        holder.itemView.tvTemperatureAdapterWeather.text = weathers[position].tempC.toString()

        holder.itemView.setOnClickListener {
            val action = WeatherFragmentDirections.actionWeatherFragmentToMapFragment(
                weathers[position].name,
                weathers[position].lat,
                weathers[position].lng
            )
            viewFrag.findNavController().navigate(action)
        }
    }
}
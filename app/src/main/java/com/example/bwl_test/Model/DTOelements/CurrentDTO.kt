package com.example.bwl_test.Model.DTOelements

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Generated("com.robohorse.robopojogenerator")
data class CurrentDTO(

	@field:SerializedName("last_updated_epoch")
	val lastUpdatedEpoch: Int? = null,

	@field:SerializedName("last_updated")
	val lastUpdated: String? = null,

	@field:SerializedName("temp_c")
	val tempC: Int? = null,

	@field:SerializedName("temp_f")
	val tempF: Any? = null,

	@field:SerializedName("is_day")
	val isDay: Int? = null,

	@field:SerializedName("condition")
	val condition: ConditionDTO? = null,

	@field:SerializedName("wind_mph")
	val windMph: Any? = null,

	@field:SerializedName("wind_kph")
	val windKph: Any? = null,

	@field:SerializedName("wind_degree")
	val windDegree: Int? = null,

	@field:SerializedName("wind_dir")
	val windDir: String? = null,

	@field:SerializedName("pressure_mb")
	val pressureMb: Int? = null,

	@field:SerializedName("pressure_in")
	val pressureIn: Any? = null,

	@field:SerializedName("precip_mm")
	val precipMm: Int? = null,

	@field:SerializedName("precip_in")
	val precipIn: Int? = null,

	@field:SerializedName("humidity")
	val humidity: Int? = null,

	@field:SerializedName("cloud")
	val cloud: Int? = null,

	@field:SerializedName("feelslike_c")
	val feelslikeC: Any? = null,

	@field:SerializedName("feelslike_f")
	val feelslikeF: Any? = null,

	@field:SerializedName("vis_km")
	val visKm: Int? = null,

	@field:SerializedName("vis_miles")
	val visMiles: Int? = null,

	@field:SerializedName("uv")
	val uv: Int? = null,

	@field:SerializedName("gust_mph")
	val gustMph: Any? = null,

	@field:SerializedName("gust_kph")
	val gustKph: Any? = null
)
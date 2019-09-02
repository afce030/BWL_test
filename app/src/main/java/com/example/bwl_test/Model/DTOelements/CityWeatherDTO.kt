package com.example.bwl_test.Model.DTOelements

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Generated("com.robohorse.robopojogenerator")
data class CityWeatherDTO(

	@field:SerializedName("location")
	val location: LocationDTO? = null,

	@field:SerializedName("current")
	val current: CurrentDTO? = null
)
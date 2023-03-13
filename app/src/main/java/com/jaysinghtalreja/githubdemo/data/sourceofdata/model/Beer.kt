package com.jaysinghtalreja.githubdemo.data.sourceofdata.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

@Parcelize
data class Beer(

	@Json( name = "first_brewed")
	val firstBrewed: String? = null,

	@Json( name = "attenuation_level")
	val attenuationLevel: Double? = null,

	@Json( name = "method")
	val method: Method? = null,

	@Json( name = "target_og")
	val targetOg: Double? = null,

	@Json( name = "image_url")
	val imageUrl: String? = null,

	@Json( name = "boil_volume")
	val boilVolume: BoilVolume? = null,

	@Json( name = "ebc")
	val ebc: Int? = null,

	@Json( name = "description")
	val description: String? = null,

	@Json( name = "target_fg")
	val targetFg: Int? = null,

	@Json( name = "srm")
	val srm: Double? = null,

	@Json( name = "volume")
	val volume: Volume? = null,

	@Json( name = "contributed_by")
	val contributedBy: String? = null,

	@Json( name = "abv")
	val abv: Double? = null,

	@Json( name = "food_pairing")
	val foodPairing: List<String?>? = null,

	@Json( name = "name")
	val name: String? = null,

	@Json( name = "ph")
	val ph: Double? = null,

	@Json( name = "tagline")
	val tagline: String? = null,

	@Json( name = "ingredients")
	val ingredients: Ingredients? = null,

	@Json( name = "id")
	val id: Int? = null,

	@Json( name = "ibu")
	val ibu: Double? = null,

	@Json( name = "brewers_tips")
	val brewersTips: String? = null
) : Parcelable

@Parcelize
data class Ingredients(

	@Json( name = "hops")
	val hops: List<HopsItem?>? = null,

	@Json( name = "yeast")
	val yeast: String? = null,

	@Json( name = "malt")
	val malt: List<MaltItem?>? = null
) : Parcelable

@Parcelize
data class Fermentation(

	@Json( name = "temp")
	val temp: Temp? = null
) : Parcelable

@Parcelize
data class Volume(

	@Json( name = "unit")
	val unit: String? = null,

	@Json( name = "value")
	val value: Int? = null
) : Parcelable

@Parcelize
data class MaltItem(

	@Json( name = "amount")
	val amount: Amount? = null,

	@Json( name = "name")
	val name: String? = null
) : Parcelable

@Parcelize
data class BoilVolume(

	@Json( name = "unit")
	val unit: String? = null,

	@Json( name = "value")
	val value: Int? = null
) : Parcelable

@Parcelize
data class MashTempItem(

	@Json( name = "duration")
	val duration: Int? = null,

	@Json( name = "temp")
	val temp: Temp? = null
) : Parcelable

@Parcelize
data class Amount(

	@Json( name = "unit")
	val unit: String? = null,

	@Json( name = "value")
	val value: Double? = null
) : Parcelable

@Parcelize
data class HopsItem(

	@Json( name = "add")
	val add: String? = null,

	@Json( name = "amount")
	val amount: Amount? = null,

	@Json( name = "name")
	val name: String? = null,

	@Json( name = "attribute")
	val attribute: String? = null
) : Parcelable

@Parcelize
data class Temp(

	@Json( name = "unit")
	val unit: String? = null,

	@Json( name = "value")
	val value: Int? = null
) : Parcelable

@Parcelize
data class Method(

	@Json( name = "mash_temp")
	val mashTemp: List<MashTempItem?>? = null,

	@Json( name = "fermentation")
	val fermentation: Fermentation? = null,

	@Json( name = "twist")
	val twist: String? = null
) : Parcelable

package com.jaysinghtalreja.githubdemo.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jaysinghtalreja.githubdemo.data.sourceofdata.entity.*

object TypeConverter {
    @TypeConverter
    @JvmStatic
    fun fromStringToList(value: String?): List<String?>? {
        val listType =
            object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }
    @TypeConverter
    @JvmStatic
    fun fromListToString(list: List<String?>?): String? { //need to use this
        val gson = Gson()
        return gson.toJson(list)
    }


    /**
     * Ingredient Type Converter
     */
    @TypeConverter
    @JvmStatic
    fun fromIngredientsToString(ingredients: Ingredients) : String {
        return Gson().toJson(ingredients)
    }
    @TypeConverter
    @JvmStatic
    fun fromStringToIngredient(value: String) : Ingredients {
        val ingredientType = object : TypeToken<Ingredients>() {}.type
        return Gson().fromJson(value, ingredientType)
    }

    /**
     * Volume Type Converters
     */
    @TypeConverter
    @JvmStatic
    fun fromVolumeToString(volume:  Volume) : String {
        return Gson().toJson(volume)
    }
    @TypeConverter
    @JvmStatic
    fun fromStringToVolume(value: String) : Volume {
        val volumeType = object : TypeToken<Volume>() {}.type
        return Gson().fromJson(value, volumeType)
    }

    /**
     * MailItem
     */
    @TypeConverter
    @JvmStatic
    fun fromMaltItemToString(maltItem: MaltItem) : String{
        return Gson().toJson(maltItem)
    }
    @TypeConverter
    @JvmStatic
    fun fromStringToMaltItem(value: String) : MaltItem{
        val maltType = object : TypeToken<MaltItem>() {}.type
        return Gson().fromJson(value, maltType)
    }

    /**
     * BoilVolume
     */
    @TypeConverter
    @JvmStatic
    fun fromBoilVolumeToString(boilVolume: BoilVolume) : String{
        return Gson().toJson(boilVolume)
    }
    @TypeConverter
    @JvmStatic
    fun fromStringToBoilVolume(value: String) : BoilVolume{
        val boilVolumeType = object : TypeToken<BoilVolume>() {}.type
        return Gson().fromJson(value, boilVolumeType)
    }

    /**
     * MashTempItem
     */

    @TypeConverter
    @JvmStatic
    fun fromMeshTempItemToString(mashTempItem: MashTempItem) : String{
        return Gson().toJson(mashTempItem)
    }
    @TypeConverter
    @JvmStatic
    fun fromStringToMeshTempItem(value: String) : MashTempItem {
        val meshTempItemType = object : TypeToken<MashTempItem>() {}.type
        return Gson().fromJson(value, meshTempItemType)
    }

    /**
     * Amount
     */

    @TypeConverter
    @JvmStatic
    fun fromAmountToString(amount: Amount) : String{
        return Gson().toJson(amount)
    }
    @TypeConverter
    @JvmStatic
    fun fromStringToAmount(value: String) : Amount {
        val amountType = object : TypeToken<Amount>() {}.type
        return Gson().fromJson(value, amountType)
    }

    /**
     * HopsItem
     */

    @TypeConverter
    @JvmStatic
    fun fromHopsItemToString(hopsItem: HopsItem) : String{
        return Gson().toJson(hopsItem)
    }
    @TypeConverter
    @JvmStatic
    fun fromStringToHopsItem(value: String) : HopsItem {
        val hopsItemType = object : TypeToken<HopsItem>() {}.type
        return Gson().fromJson(value, hopsItemType)
    }

    /**
     * Temp
     */
    @TypeConverter
    @JvmStatic
    fun fromTempToString(temp: Temp) : String{
        return Gson().toJson(temp)
    }
    @TypeConverter
    @JvmStatic
    fun fromStringToTemp(value: String) : Temp {
        val tempType = object : TypeToken<Temp>() {}.type
        return Gson().fromJson(value, tempType)
    }

    /**
     * Method
     */

    @TypeConverter
    @JvmStatic
    fun fromMethodToString(method: Method) : String{
        return Gson().toJson(method)
    }
    @TypeConverter
    @JvmStatic
    fun fromStringToMethod(value: String) : Method {
        val methodType = object : TypeToken<Method>() {}.type
        return Gson().fromJson(value, methodType)
    }


}
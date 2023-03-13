package com.jaysinghtalreja.githubdemo.data.sourceofdata.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.jaysinghtalreja.githubdemo.data.sourceofdata.model.Fermentation
import com.jaysinghtalreja.githubdemo.data.sourceofdata.model.HopsItem
import com.jaysinghtalreja.githubdemo.data.sourceofdata.model.MaltItem
import com.jaysinghtalreja.githubdemo.data.sourceofdata.model.MashTempItem


@Entity(
    tableName = Beer.TABLE_NAME,
    indices = [Index("id", unique = true)]
)
data class Beer(

    @PrimaryKey
    @ColumnInfo( name = "id")
    val id: Int? = null,

    @ColumnInfo( name = "first_brewed")
    val firstBrewed: String? = null,

    @ColumnInfo( name = "attenuation_level")
    val attenuationLevel: Double? = null,

    @ColumnInfo( name = "method")
    val method: Method? = null,

    @ColumnInfo( name = "target_og")
    val targetOg: Double? = null,

    @ColumnInfo( name = "image_url")
    val imageUrl: String? = null,

    @ColumnInfo( name = "boil_volume")
    val boilVolume: BoilVolume? = null,

    @ColumnInfo( name = "ebc")
    val ebc: Int? = null,

    @ColumnInfo( name = "description")
    val description: String? = null,

    @ColumnInfo( name = "target_fg")
    val targetFg: Int? = null,

    @ColumnInfo( name = "srm")
    val srm: Double? = null,

    @ColumnInfo( name = "volume")
    val volume: Volume? = null,

    @ColumnInfo( name = "contributed_by")
    val contributedBy: String? = null,

    @ColumnInfo( name = "abv")
    val abv: Double? = null,

    @ColumnInfo( name = "food_pairing")
    val foodPairing: List<String?>? = null,

    @ColumnInfo( name = "name")
    val name: String? = null,

    @ColumnInfo( name = "ph")
    val ph: Double? = null,

    @ColumnInfo( name = "tagline")
    val tagline: String? = null,

    @ColumnInfo( name = "ingredients")
    val ingredients: Ingredients? = null,

    @ColumnInfo( name = "ibu")
    val ibu: Double? = null,

    @ColumnInfo( name = "brewers_tips")
    val brewersTips: String? = null,

    var isSelected : Boolean = false
) : java.io.Serializable {
    companion object {
        /**
         * Table name to store categories
         */
        const val TABLE_NAME: String = "beers"
    }
}

data class Ingredients(

    @ColumnInfo( name = "hops")
    val hops: List<HopsItem?>? = null,

    @ColumnInfo( name = "yeast")
    val yeast: String? = null,

    @ColumnInfo( name = "malt")
    val malt: List<MaltItem?>? = null
)

data class Fermentation(

    @ColumnInfo( name = "temp")
    val temp: Temp? = null
)

data class Volume(

    @ColumnInfo( name = "unit")
    val unit: String? = null,

    @ColumnInfo( name = "value")
    val value: Int? = null
)

data class MaltItem(

    @ColumnInfo( name = "amount")
    val amount: Amount? = null,

    @ColumnInfo( name = "name")
    val name: String? = null
)

data class BoilVolume(

    @ColumnInfo( name = "unit")
    val unit: String? = null,

    @ColumnInfo( name = "value")
    val value: Int? = null
)

data class MashTempItem(

    @ColumnInfo( name = "duration")
    val duration: Int? = null,

    @ColumnInfo( name = "temp")
    val temp: Temp? = null
)

data class Amount(

    @ColumnInfo( name = "unit")
    val unit: String? = null,

    @ColumnInfo( name = "value")
    val value: Double? = null
)

data class HopsItem(

    @ColumnInfo( name = "add")
    val add: String? = null,

    @ColumnInfo( name = "amount")
    val amount: Amount? = null,

    @ColumnInfo( name = "name")
    val name: String? = null,

    @ColumnInfo( name = "attribute")
    val attribute: String? = null
)

data class Temp(

    @ColumnInfo( name = "unit")
    val unit: String? = null,

    @ColumnInfo( name = "value")
    val value: Int? = null
)

data class Method(

    @ColumnInfo( name = "mash_temp")
    val mashTemp: List<MashTempItem?>? = null,

    @ColumnInfo( name = "fermentation")
    val fermentation: Fermentation? = null,

    @ColumnInfo( name = "twist")
    val twist: String? = null
)

package com.dashkevich.gourmets.data.api.model


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("carbohydrates_per_100_grams")
    val carbohydratesPer100Grams: Double,
    @SerializedName("category_id")
    val categoryId: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("energy_per_100_grams")
    val energyPer100Grams: Double,
    @SerializedName("fats_per_100_grams")
    val fatsPer100Grams: Double,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("measure")
    val measure: Int,
    @SerializedName("measure_unit")
    val measureUnit: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price_current")
    val priceCurrent: Int,
    @SerializedName("price_old")
    val priceOld: Any?,
    @SerializedName("proteins_per_100_grams")
    val proteinsPer100Grams: Double,
    @SerializedName("tag_ids")
    val tagIds: List<Int>
)
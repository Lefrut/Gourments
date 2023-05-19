package com.dashkevich.gourmets.data.api.model


import com.google.gson.annotations.SerializedName

data class TagX(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)
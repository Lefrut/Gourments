package com.dashkevich.gourmets.ui.screens.catalog.model

class FoodCatalog(
    val id: Int,
    val name: String,
    val oldPrice: Int?,
    val currentPrice: Int,
    val weight: Int,
    val weight_unit: String,
    val image: String
)
package com.ephemerayne.leroymerlinmainuitest.domain.entity

data class Product(
    var id: Int? = null,
    val title: String,
    val price: Double,
    val imageURL: String,
    var isLimitedOffer: Boolean = false,
    var isBestPrice: Boolean = false
)
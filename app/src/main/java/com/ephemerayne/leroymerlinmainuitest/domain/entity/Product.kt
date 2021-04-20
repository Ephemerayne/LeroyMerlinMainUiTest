package com.ephemerayne.leroymerlinmainuitest.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_table")
data class Product(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    val title: String,
    val price: Double,
    val imageURL: String,
    var isLimitedOffer: Boolean = false,
    var isBestPrice: Boolean = false
)
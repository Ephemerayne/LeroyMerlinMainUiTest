package com.ephemerayne.leroymerlinmainuitest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories_table")
data class CategoryModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val title: String,
    val imageURL: String
)


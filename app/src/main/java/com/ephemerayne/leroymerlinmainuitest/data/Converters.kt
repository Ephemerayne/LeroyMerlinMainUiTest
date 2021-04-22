package com.ephemerayne.leroymerlinmainuitest.data

import com.ephemerayne.leroymerlinmainuitest.data.model.CategoryModel
import com.ephemerayne.leroymerlinmainuitest.data.model.ProductModel
import com.ephemerayne.leroymerlinmainuitest.domain.entity.CategoryEntity
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductEntity

fun CategoryEntity.toModel(): CategoryModel = CategoryModel(
    id = id,
    title = title,
    imageURL = imageURL
)

fun CategoryModel.toEntity(): CategoryEntity = CategoryEntity(
    id = id,
    title = title,
    imageURL = imageURL
)

fun ProductModel.toEntity(): ProductEntity = ProductEntity(
    id, title, price, imageURL, isLimitedOffer, isBestPrice
)

fun ProductEntity.toModel(): ProductModel = ProductModel(
    id, title, price, imageURL, isLimitedOffer, isBestPrice
)

package com.ephemerayne.leroymerlinmainuitest.ui.home

import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductEntity

interface ProductListener {

    fun onProductClick(productEntity: ProductEntity)
}
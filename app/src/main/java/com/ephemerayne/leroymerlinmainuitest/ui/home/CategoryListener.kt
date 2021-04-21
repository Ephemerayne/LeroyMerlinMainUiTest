package com.ephemerayne.leroymerlinmainuitest.ui.home

import com.ephemerayne.leroymerlinmainuitest.domain.entity.CategoryEntity

public interface CategoryListener {

    fun onProductCategoryClick(categoryEntity: CategoryEntity)

    fun onCatalogCategoryClick()

    fun onAllCategoryClick()
}

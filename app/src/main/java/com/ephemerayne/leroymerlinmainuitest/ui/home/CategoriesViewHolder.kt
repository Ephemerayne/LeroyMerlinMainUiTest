package com.ephemerayne.leroymerlinmainuitest.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.leroymerlinmainuitest.R
import com.ephemerayne.leroymerlinmainuitest.databinding.CategoryItemAllBinding
import com.ephemerayne.leroymerlinmainuitest.databinding.CategoryItemBinding
import com.ephemerayne.leroymerlinmainuitest.databinding.CategoryItemCatalogBinding
import com.ephemerayne.leroymerlinmainuitest.domain.entity.AllCategory
import com.ephemerayne.leroymerlinmainuitest.domain.entity.CatalogCategory
import com.ephemerayne.leroymerlinmainuitest.domain.entity.CategoryEntity

abstract class CategoriesViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun setContent(item: T)
}

class ProductCategoryViewHolder(
    private val binding: CategoryItemBinding
) : CategoriesViewHolder<CategoryEntity>(binding.root) {

    override fun setContent(categoryEntity: CategoryEntity) {
            binding.categoryName.text = categoryEntity.title
        }
}

class CatalogCategoryViewHolder(
    private val binding: CategoryItemCatalogBinding
): CategoriesViewHolder<CatalogCategory>(binding.root) {

    override fun setContent(category: CatalogCategory) {
           binding.categoryCatalogName.text = itemView.context.getString(R.string.catalog_name)
    }
}

class AllCategoryViewHolder(
    private val binding: CategoryItemAllBinding
): CategoriesViewHolder<AllCategory>(binding.root) {

    override fun setContent(item: AllCategory) {
        binding.categoryAll.text = itemView.context.getString(R.string.see_all)
    }
}
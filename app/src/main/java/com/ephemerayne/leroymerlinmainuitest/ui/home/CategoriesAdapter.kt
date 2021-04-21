package com.ephemerayne.leroymerlinmainuitest.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.leroymerlinmainuitest.databinding.CategoryItemAllBinding
import com.ephemerayne.leroymerlinmainuitest.databinding.CategoryItemBinding
import com.ephemerayne.leroymerlinmainuitest.databinding.CategoryItemCatalogBinding
import com.ephemerayne.leroymerlinmainuitest.domain.entity.AllCategory
import com.ephemerayne.leroymerlinmainuitest.domain.entity.CatalogCategory
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Category
import com.ephemerayne.leroymerlinmainuitest.domain.entity.CategoryEntity


class CategoriesAdapter(context: Context) : RecyclerView.Adapter<CategoriesViewHolder<*>>() {

    private val inflater = LayoutInflater.from(context)

    companion object {
        private const val CATALOG_TYPE = 0
        private const val PRODUCT_TYPE = 1
        private const val ALL_TYPE = 2

    }

    private val categories: ArrayList<Category> = arrayListOf()

    fun setCategories(categories: List<Category>) = with(this.categories) {
        clear()
        addAll(categories)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesViewHolder<*> =
        when (viewType) {
            CATALOG_TYPE -> CatalogCategoryViewHolder(
                CategoryItemCatalogBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            ALL_TYPE -> AllCategoryViewHolder(
                CategoryItemAllBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            PRODUCT_TYPE -> ProductCategoryViewHolder(
                CategoryItemBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid view type.")
        }

    override fun getItemViewType(position: Int): Int {
        return when (categories[position]) {
            is CatalogCategory -> CATALOG_TYPE
            is AllCategory -> ALL_TYPE
            is CategoryEntity -> PRODUCT_TYPE
            else -> throw IllegalArgumentException("Invalid type of data $position.")
        }
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: CategoriesViewHolder<*>, position: Int) {
        val category = categories[position]
        when (holder) {
            is CatalogCategoryViewHolder -> holder.setContent(category as CatalogCategory)
            is AllCategoryViewHolder -> holder.setContent(category as AllCategory)
            is ProductCategoryViewHolder -> holder.setContent(category as CategoryEntity)
            else -> throw IllegalArgumentException("Adapter can not set content.")
        }
    }
}

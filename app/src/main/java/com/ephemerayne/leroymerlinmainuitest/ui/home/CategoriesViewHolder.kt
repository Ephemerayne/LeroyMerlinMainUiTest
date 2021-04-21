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
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

abstract class CategoriesViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun setContent(item: T)
}

class ProductCategoryViewHolder(
    private val binding: CategoryItemBinding,
    private val onCategoryClickListener: CategoryListener
) : CategoriesViewHolder<CategoryEntity>(binding.root) {

    override fun setContent(categoryEntity: CategoryEntity) {
        binding.categoryName.text = categoryEntity.title

        binding.root.setOnClickListener {
            onCategoryClickListener.onProductCategoryClick(categoryEntity)
        }
        setCategoryImage(categoryEntity)
    }

    private fun setCategoryImage(categoryEntity: CategoryEntity) {
        if (categoryEntity.imageURL.isNotEmpty()) {
            Picasso.get().load(categoryEntity.imageURL).into(binding.categoryImage, object:Callback.EmptyCallback() {

                override fun onSuccess() {
                    super.onSuccess()
                    binding.shimmerImage.visibility = View.GONE
                    binding.categoryName.visibility = View.VISIBLE
                    binding.categoryImage.visibility = View.VISIBLE
                }

                override fun onError(e: Exception?) {
                    super.onError(e)
                }
            })
        }
    }
}

class CatalogCategoryViewHolder(
    private val binding: CategoryItemCatalogBinding,
    private val onCategoryClickListener: CategoryListener
) : CategoriesViewHolder<CatalogCategory>(binding.root) {

    override fun setContent(category: CatalogCategory) {
        binding.categoryCatalogName.text = itemView.context.getString(R.string.catalog_name)
        binding.root.setOnClickListener {
            onCategoryClickListener.onCatalogCategoryClick()
        }
    }
}

class AllCategoryViewHolder(
    private val binding: CategoryItemAllBinding,
    private val onCategoryClickListener: CategoryListener
) : CategoriesViewHolder<AllCategory>(binding.root) {

    override fun setContent(item: AllCategory) {
        binding.categoryAll.text = itemView.context.getString(R.string.see_all)
        binding.root.setOnClickListener {
            onCategoryClickListener.onAllCategoryClick()
        }
    }
}
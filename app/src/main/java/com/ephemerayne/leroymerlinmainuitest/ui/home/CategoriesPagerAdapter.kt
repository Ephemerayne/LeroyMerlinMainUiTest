package com.ephemerayne.leroymerlinmainuitest.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.leroymerlinmainuitest.databinding.CategoryItemBinding
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Category

class CategoriesPagerAdapter : RecyclerView.Adapter<CategoriesPagerAdapter.CategoryViewHolder>() {

    private val categories: ArrayList<Category> = arrayListOf()

    fun setCategories(categories: List<Category>) = with(this.categories) {
        clear()
        addAll(categories)
        notifyDataSetChanged()
    }

    class CategoryViewHolder(
        private val binding: CategoryItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun setCategoryContent(category: Category) = with(binding) {
            categoryName.text = category.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
        CategoryViewHolder(
            CategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) =
        holder.setCategoryContent(categories[position])

    override fun getItemCount(): Int = categories.size


}
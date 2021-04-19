package com.ephemerayne.leroymerlinmainuitest.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.leroymerlinmainuitest.R
import com.ephemerayne.leroymerlinmainuitest.databinding.CategoryItemBinding
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Category


class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    private val categories: ArrayList<Category> = arrayListOf()

    fun setCategories(categories: List<Category>) = with(this.categories) {
        clear()
        addAll(categories)
        notifyDataSetChanged()
    }

    class CategoryViewHolder(
        private val binding: CategoryItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun setCategoryContent(category: Category, position: Int, categories: ArrayList<Category>) =
            with(binding) {
                categoryName.text = category.title

                if (position == 0 || position == categories.size - 1) {
                    cardViewCategory.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.green
                        )
                    )
                } else {
                    cardViewCategory.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.light_grey
                        )
                    )
                }
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

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.setCategoryContent(categories[position], position, categories)
    }

    override fun getItemCount(): Int = categories.size
}
package com.ephemerayne.leroymerlinmainuitest.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.leroymerlinmainuitest.databinding.ProductItemBinding
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductEntity

class ProductViewHolder(
    private val binding: ProductItemBinding,
    private val onProductListener: ProductListener
) : RecyclerView.ViewHolder(binding.root) {

    fun setProductContent(productEntity: ProductEntity) = with(binding) {
        price.text = productEntity.price.toString()
        title.text = productEntity.title

        root.setOnClickListener {
            onProductListener.onProductClick(productEntity)
        }
    }
}
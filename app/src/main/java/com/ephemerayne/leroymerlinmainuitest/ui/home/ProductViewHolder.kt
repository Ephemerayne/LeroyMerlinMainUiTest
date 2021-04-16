package com.ephemerayne.leroymerlinmainuitest.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.leroymerlinmainuitest.databinding.ProductItemBinding
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Product

class ProductViewHolder(
    private val binding: ProductItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setProductContent(product: Product) = with(binding) {
        price.text = product.price.toString()
        title.text = product.title
    }
}
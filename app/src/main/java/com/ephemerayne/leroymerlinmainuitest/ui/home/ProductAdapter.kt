package com.ephemerayne.leroymerlinmainuitest.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.leroymerlinmainuitest.databinding.ProductItemBinding
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Product

class ProductAdapter : RecyclerView.Adapter<ProductViewHolder>() {

    private val products: ArrayList<Product> = arrayListOf()

    fun setProducts(products: List<Product>) = with(this.products) {
        clear()
        addAll(products)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.setProductContent(products[position])

    override fun getItemCount() = products.size
}
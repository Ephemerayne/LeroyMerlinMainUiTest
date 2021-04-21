package com.ephemerayne.leroymerlinmainuitest.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.leroymerlinmainuitest.databinding.ProductItemBinding
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductEntity

class ProductAdapter(
private val onProductListener: ProductListener,
) : RecyclerView.Adapter<ProductViewHolder>() {

    private val productEntities: ArrayList<ProductEntity> = arrayListOf()

    fun setProducts(productEntities: List<ProductEntity>) = with(this.productEntities) {
        clear()
        addAll(productEntities)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ProductViewHolder(binding, onProductListener)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.setProductContent(productEntities[position])

    override fun getItemCount() = productEntities.size
}
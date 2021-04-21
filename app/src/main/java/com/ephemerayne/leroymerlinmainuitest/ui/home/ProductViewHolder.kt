package com.ephemerayne.leroymerlinmainuitest.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.leroymerlinmainuitest.databinding.ProductItemBinding
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductEntity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

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
        setProductImage(productEntity)
    }

    private fun setProductImage(productEntity: ProductEntity) {
        if (productEntity.imageURL.isNotEmpty()) {
            Picasso.get().load(productEntity.imageURL).into(binding.imageProduct, object : Callback.EmptyCallback(){
                override fun onSuccess() {
                    super.onSuccess()
                    binding.shimmer.visibility = View.GONE
                    binding.imageProduct.visibility = View.VISIBLE
                }

                override fun onError(e: Exception?) {
                    super.onError(e)
                }
            })
        }
    }
}
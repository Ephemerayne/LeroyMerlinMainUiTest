package com.ephemerayne.leroymerlinmainuitest.ui.home

import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.leroymerlinmainuitest.R
import com.ephemerayne.leroymerlinmainuitest.databinding.ProductItemBinding
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductEntity
import com.ephemerayne.leroymerlinmainuitest.formatPrice
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class ProductViewHolder(
    private val binding: ProductItemBinding,
    private val onProductListener: ProductListener
) : RecyclerView.ViewHolder(binding.root) {

    fun setProductContent(productEntity: ProductEntity) = with(binding) {
        val formattedPrice = String.format(
            root.resources.getString(R.string.price),
            productEntity.price.formatPrice()
        )

        var spanString = SpannableString(formattedPrice)
        spanString.setSpan(
            RelativeSizeSpan(0.75f),
            formattedPrice.indexOfFirst { it == ',' || it == ' ' },
            formattedPrice.length,
            0
        )

        price.text = spanString
        title.text = productEntity.title

        root.setOnClickListener {
            onProductListener.onProductClick(productEntity)
        }
        setProductImage(productEntity)
    }

    private fun setProductImage(productEntity: ProductEntity) {
        if (productEntity.imageURL.isNotEmpty()) {
            Picasso.get().load(productEntity.imageURL)
                .into(binding.imageProduct, object : Callback.EmptyCallback() {
                    override fun onSuccess() {
                        super.onSuccess()
                        binding.productShimmers.root.visibility = View.GONE

                        binding.imageProduct.visibility = View.VISIBLE
                        binding.price.visibility = View.VISIBLE
                        binding.title.visibility = View.VISIBLE
                    }

                    override fun onError(e: Exception?) {
                        super.onError(e)
                    }
                })
        }
    }
}

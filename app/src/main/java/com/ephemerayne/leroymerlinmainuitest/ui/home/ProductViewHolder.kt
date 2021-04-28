package com.ephemerayne.leroymerlinmainuitest.ui.home

import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.leroymerlinmainuitest.App
import com.ephemerayne.leroymerlinmainuitest.R
import com.ephemerayne.leroymerlinmainuitest.databinding.ProductItemBinding
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductEntity
import com.ephemerayne.leroymerlinmainuitest.formatPrice
import com.ephemerayne.leroymerlinmainuitest.utils.ImageLoader
import javax.inject.Inject

class ProductViewHolder(
    private val binding: ProductItemBinding,
    private val onProductListener: ProductListener,
) : RecyclerView.ViewHolder(binding.root) {

    @Inject
    lateinit var imageLoader: ImageLoader

    init {
        App.appComponent.inject(this)
    }

    fun setProductContent(productEntity: ProductEntity) {

        binding.title.text = productEntity.title
        binding.price.text = formatViewProductPrice(productEntity.price)

        binding.root.setOnClickListener {
            onProductListener.onProductClick(productEntity)
        }

        setProductImage(productEntity)
    }

    private fun formatViewProductPrice(price: Double): SpannableString {
        val formattedPrice = String.format(
            binding.root.resources.getString(R.string.price),
            price.formatPrice()
        )

        val decoratePrice = SpannableString(formattedPrice)
        return decoratePrice.apply {
            setSpan(
                RelativeSizeSpan(0.75f),
                formattedPrice.indexOfFirst { it == ',' || it == ' ' },
                formattedPrice.length,
                0
            )
        }
    }

    private fun setProductImage(productEntity: ProductEntity) {
        if (productEntity.imageURL.isNotEmpty()) {
            imageLoader.loadImage(
                productEntity.imageURL,
                binding.imageProduct,
                binding.productShimmers.root,
                binding.price,
                binding.title
            )
        }
    }
}

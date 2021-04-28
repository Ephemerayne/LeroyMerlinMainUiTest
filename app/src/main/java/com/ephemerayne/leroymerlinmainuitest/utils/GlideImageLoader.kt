package com.ephemerayne.leroymerlinmainuitest.utils

import android.app.Application
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import javax.inject.Inject

class GlideImageLoader @Inject constructor(private val application: Application): ImageLoader {
    override fun loadImage(
        url: String,
        imageView: ImageView,
        shimmer: View,
        price: TextView,
        title: TextView
    ) {
        Glide.with(application).load(url).centerCrop().listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                println(e)
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                shimmer.visibility = View.GONE

                imageView.visibility = View.VISIBLE
                price.visibility = View.VISIBLE
                title.visibility = View.VISIBLE

                return false
            }


        }).into(imageView)
    }
}
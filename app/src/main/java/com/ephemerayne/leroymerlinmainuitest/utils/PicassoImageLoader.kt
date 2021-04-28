package com.ephemerayne.leroymerlinmainuitest.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class PicassoImageLoader : ImageLoader {

    override fun loadImage(
        url: String,
        imageView: ImageView,
        shimmer: View,
        price: TextView,
        title: TextView
    ) {
        Picasso.get().load(url)
            .into(imageView, object : Callback.EmptyCallback() {
                override fun onSuccess() {
                    super.onSuccess()
                    shimmer.visibility = View.GONE

                    imageView.visibility = View.VISIBLE
                    price.visibility = View.VISIBLE
                    title.visibility = View.VISIBLE
                }

                override fun onError(e: Exception?) {
                    super.onError(e)
                }
            })
    }
}
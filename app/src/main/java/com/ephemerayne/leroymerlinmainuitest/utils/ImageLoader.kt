package com.ephemerayne.leroymerlinmainuitest.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView

interface ImageLoader {

    fun loadImage(url: String, imageView: ImageView, shimmer: View, price: TextView, title: TextView)
}
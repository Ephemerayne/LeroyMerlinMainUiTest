package com.ephemerayne.leroymerlinmainuitest

import android.text.Spannable
import android.text.style.RelativeSizeSpan

fun String.increaseFontSize(spannable: Spannable, path: String, increaseTime: Float) {
    var startIndex = spannable.toString().indexOf(path)
    spannable.setSpan(RelativeSizeSpan(increaseTime), startIndex, startIndex + path.length, 0)

}
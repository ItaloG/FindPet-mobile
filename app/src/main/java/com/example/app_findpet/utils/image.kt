package com.example.app_findpet.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.net.URL

fun converterUrlParaBitmap(url: String?): Bitmap? {
    val newurl = URL(url)
    val image = BitmapFactory.decodeStream(newurl.openConnection().getInputStream())

    return image
}
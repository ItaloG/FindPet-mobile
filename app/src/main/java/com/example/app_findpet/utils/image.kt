package com.example.app_findpet.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.ByteArrayOutputStream
import java.net.URL

fun converterBitmapParaBitArray(imagem: Bitmap?): ByteArray? {

    val stream = ByteArrayOutputStream()

    if (imagem != null) {
        val imageArray = imagem!!.compress(
            Bitmap.CompressFormat.PNG, 0, stream
        )
        return stream.toByteArray()
    }

    return null
}

fun converterByteArrayParaBitmap(imageArray: ByteArray): Bitmap {

    return BitmapFactory.decodeByteArray(
        imageArray, 0, imageArray.size
    )
}
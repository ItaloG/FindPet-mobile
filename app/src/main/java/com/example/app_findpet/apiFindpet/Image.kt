package com.example.app_findpet.apiFindpet

import android.graphics.Bitmap

class Image {

    var image: Bitmap? = null
    var url: String = ""

    override fun toString(): String {
        return "url = $url"
    }

}
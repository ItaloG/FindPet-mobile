package com.example.app_findpet.apiFindpet

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactoryFindpet {

    var URL = "http://10.0.2.2:3333/"

    var retrofitFactoryFindpet =
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun retrofitServiceFindpet() : RetrofitServiceFindpet {
        return retrofitFactoryFindpet.create(RetrofitServiceFindpet::class.java)
    }

}
package com.example.app_findpet.apiViacep

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactoryViacep {

    var URL = "https://viacep.com.br/ws/"

    val retrofitFactory =
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun retrofitService() : RetrofitServiceViacep {
        return retrofitFactory.create(RetrofitServiceViacep::class.java)
    }

}
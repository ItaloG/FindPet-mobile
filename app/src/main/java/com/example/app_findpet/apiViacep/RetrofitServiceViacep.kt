package com.example.app_findpet.apiViacep

import com.example.app_findpet.apiViacep.Cep
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitServiceViacep {
    @GET("{CEP}/json/")
    fun getCep(@Path("CEP") cep: String): Call<Cep>
}
package com.example.app_findpet.apiFindpet

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitServiceFindpet {
    @POST("cadastro/instituicao")
    fun criarInstituicao(@Body instituicao: Instituicao): Call<Instituicao>

    @POST("cadastro/usuario")
    fun criarUsuario(@Body usuario: Usuario): Call<Usuario>
}
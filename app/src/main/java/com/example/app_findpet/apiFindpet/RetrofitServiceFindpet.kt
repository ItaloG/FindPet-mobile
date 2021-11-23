package com.example.app_findpet.apiFindpet

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServiceFindpet {
    @POST("cadastro/instituicao")
    fun criarInstituicao(@Body instituicao: Instituicao): Call<Instituicao>

    @POST("cadastro/usuario")
    fun criarUsuario(@Body usuario: Usuario): Call<Usuario>

    @POST("login")
    fun login(@Body login: Login): Call<Login>

    @Multipart
    @PUT("instituicoes/{id}/perfil")
    fun trocarFotoPerfilInstituicao(
        @Header("Authorization") authorization: String,
        @Path("id") id: Int,
        @Part("image") image: RequestBody
    ): Call<Image>

    @PUT("instituicoes/{id}/descricao")
    fun enviarDescricao(
        @Header("Authorization") authorization: String,
        @Path("id") id: Int,
        @Body descricao: Descricao
    ): Call<Descricao>
}
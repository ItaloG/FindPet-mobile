package com.example.app_findpet.apiFindpet

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
    @PUT("instituicoes/:id/perfil")
    fun trocarFotoPerfilInstituicao(
        @Header("Authorization") authorization: String,
        @Path("id") id: Int,
        @Body image: Image
    ): Call<Image>
}
package com.example.app_findpet.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.app_findpet.R

class perfilInstituicaoVisaoInstituicaoActivity : AppCompatActivity() {

    lateinit var ivBannerInstituicao: ImageView
    lateinit var ivPerfilInstituicao: ImageView
    lateinit var tvNomeInstituicao: TextView
    lateinit var tvEmailInstituicaio: TextView
    lateinit var tvRuaInstituicao: TextView
    lateinit var tvTelefoneInstituicao: TextView
    lateinit var tvCelularInstituicao: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_instituicao_visao_instituicao)

        tvNomeInstituicao = findViewById(R.id.tv_nome_instituicao)
        ivBannerInstituicao = findViewById(R.id.iv_banner_instituicao)
        ivPerfilInstituicao = findViewById(R.id.iv_perfil_instituicao)
        tvEmailInstituicaio = findViewById(R.id.tv_email_instituicao)
        tvRuaInstituicao = findViewById(R.id.tv_rua_instituicao)
        tvTelefoneInstituicao = findViewById(R.id.tv_telefone_instituicao)
        tvCelularInstituicao = findViewById(R.id.tv_celular_instituicao)

        preencherTelaPerfil()

    }

    private fun preencherTelaPerfil() {
        val dados = getSharedPreferences("dados_usuario", Context.MODE_PRIVATE)

        tvNomeInstituicao.text = dados.getString("nome", "")
        tvEmailInstituicaio.text = dados.getString("email", "")
        tvRuaInstituicao.text = dados.getString("logradouro", "")
        tvTelefoneInstituicao.text = dados.getString("telefone", "")
        tvCelularInstituicao.text = dados.getString("celular", "")
        val urlBanner = dados.getString("url_foto_banner", "")
        Glide.with(this).load(urlBanner).into(ivBannerInstituicao)
        val urlPerfil = dados.getString("url_foto_perfil", "")
        Glide.with(this).load(urlPerfil).into(ivPerfilInstituicao)

    }
}
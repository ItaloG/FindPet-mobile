package com.example.app_findpet

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import com.example.app_findpet.apiFindpet.Image
import com.example.app_findpet.apiFindpet.RetrofitFactoryFindpet
import retrofit2.Response

const val CODE_IMAGE = 100

class perfilInstituicaoVisaoInstituicaoActivity : AppCompatActivity() {

    var imageBitMap: Bitmap? = null

    lateinit var ivBannerInstituicao: ImageView
    lateinit var ivPerfilInstituicao: ImageView
    lateinit var tvNomeInstituicao: TextView
    lateinit var tvEmailInstituicaio: TextView
    lateinit var tvRuaInstituicao: TextView
    lateinit var tvTelefoneInstituicao: TextView
    lateinit var tvCelularInstituicao: TextView
    lateinit var tvTrocarFoto: TextView

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
        tvTrocarFoto = findViewById(R.id.tv_trocar_foto_instituicao)

        tvTrocarFoto.setOnClickListener {
            abrirGaleria()
        }

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

    private fun abrirGaleria() {

        val intent = Intent(Intent.ACTION_GET_CONTENT)

        intent.type = "image/*"

        startActivityForResult(
            Intent.createChooser(
                intent,
                "Escolha uma foto"
            ),
            CODE_IMAGE
        )
    }

    private fun trocarFotoPerfil() {
        var image = Image()

        image.image = imageBitMap

        val dados = getSharedPreferences("dados_usuario", Context.MODE_PRIVATE)
        val token = dados.getString("token", "")
        val id = dados.getInt("id", 0)
        val remote = RetrofitFactoryFindpet().retrofitServiceFindpet()
        val call: Call<Image> = remote.trocarFotoPerfilInstituicao("Bearer $token", id, image)

        call.enqueue(object : Callback<Image> {
            override fun onResponse(call: Call<Image>, response: Response<Image>) {
                val imagem = response.body()
                Log.i("xpto", imagem.toString())
            }

            override fun onFailure(call: Call<Image>, t: Throwable) {
                Log.i("xpto", t.message.toString())
            }

        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CODE_IMAGE && resultCode == -1) {

            // Recuperar a imagem na stream
            val stream = contentResolver.openInputStream(data!!.data!!)

            // Transformar o resultado emn um BitMap
            imageBitMap = BitmapFactory.decodeStream(stream)

            // Colocar a imgaem no ImageView
            ivPerfilInstituicao.setImageBitmap(imageBitMap)

            trocarFotoPerfil()

        }
    }
}
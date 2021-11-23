package com.example.app_findpet

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.app_findpet.apiFindpet.Image
import com.example.app_findpet.apiFindpet.RetrofitFactoryFindpet
import com.example.app_findpet.utils.converterBitmapParaBase64
import com.example.app_findpet.utils.converterBitmapParaBitArray
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File


const val CODE_IMAGE = 100

class perfilInstituicaoVisaoInstituicaoActivity : AppCompatActivity() {


    var imageBitMap: Bitmap? = null

    lateinit var buttonAdicionarColaborador: TextView
    lateinit var buttonAdicionarNovoAnimal: TextView
    lateinit var buttonAdicionarCampanhas: TextView
    lateinit var ivBannerInstituicao: ImageView
    lateinit var ivPerfilInstituicao: ImageView
    lateinit var tvNomeInstituicao: TextView
    lateinit var tvEmailInstituicaio: TextView
    lateinit var tvRuaInstituicao: TextView
    lateinit var tvTelefoneInstituicao: TextView
    lateinit var tvCelularInstituicao: TextView
    lateinit var tvTrocarFoto: TextView
    lateinit var tvDescricao: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_instituicao_visao_instituicao)

        buttonAdicionarColaborador = findViewById(R.id.funcionarios)
        buttonAdicionarNovoAnimal = findViewById(R.id.quantidade_animais)
        buttonAdicionarCampanhas = findViewById(R.id.campanhas_instituicao)
        tvNomeInstituicao = findViewById(R.id.tv_nome_instituicao)
        ivBannerInstituicao = findViewById(R.id.iv_banner_instituicao)
        ivPerfilInstituicao = findViewById(R.id.iv_perfil_instituicao)
        tvEmailInstituicaio = findViewById(R.id.tv_email_instituicao)
        tvRuaInstituicao = findViewById(R.id.tv_rua_instituicao)
        tvTelefoneInstituicao = findViewById(R.id.tv_telefone_instituicao)
        tvCelularInstituicao = findViewById(R.id.tv_celular_instituicao)
        tvTrocarFoto = findViewById(R.id.tv_trocar_foto_instituicao)
        tvDescricao = findViewById(R.id.tv_descricao)

        preencherTelaPerfil()

        tvTrocarFoto.setOnClickListener {
            abrirGaleria()
        }

        tvDescricao.setOnClickListener {

        }

        buttonAdicionarCampanhas.setOnClickListener {
            val intent = Intent(this, campanhasActivity::class.java)
            startActivity(intent)
        }

        buttonAdicionarNovoAnimal.setOnClickListener {
            val intent = Intent(this, cadastrar_novo_perfilAnimais::class.java)
            startActivity(intent)
        }

        buttonAdicionarColaborador.setOnClickListener {
            val intent = Intent(this, cadastrar_novo_perfilFuncionario::class.java)
            startActivity(intent)
        }
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


//    private fun trocarFotoPerfil() {
//        val dados = getSharedPreferences("dados_usuario", Context.MODE_PRIVATE)
//        val token = dados.getString("token", "")
//        val id = dados.getInt("id", 0)
//
//        val image: RequestBody = RequestBody.create(
//            MediaType.parse("image"),
//            converterBitmapParaBitArray(imageBitMap)
//        )
//
//        val remote = RetrofitFactoryFindpet().retrofitServiceFindpet()
//        val call: Call<Image> = remote.trocarFotoPerfilInstituicao("Bearer $token", id, image)
//
//        call.enqueue(object : Callback<Image> {
//            override fun onResponse(call: Call<Image>, response: Response<Image>) {
//                val imagem = response.body()
//                Log.i("xpto", imagem.toString())
//            }
//
//            override fun onFailure(call: Call<Image>, t: Throwable) {
//                Log.i("xpto", t.message.toString())
//            }
//
//        })
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CODE_IMAGE && resultCode == -1) {

            // Recuperar a imagem na stream
            val stream = contentResolver.openInputStream(data!!.data!!)

            // Transformar o resultado emn um BitMap
            imageBitMap = BitmapFactory.decodeStream(stream)

            // Colocar a imgaem no ImageView
            ivPerfilInstituicao.setImageBitmap(imageBitMap)

            Log.i("xpto", converterBitmapParaBase64(imageBitMap!!))

//            trocarFotoPerfil()
        }
    }
}
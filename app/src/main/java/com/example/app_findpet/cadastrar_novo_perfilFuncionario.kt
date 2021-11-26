package com.example.app_findpet

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.app_findpet.utils.converterBitmapParaBase64

const val CCODE_IMAGE = 100
class cadastrar_novo_perfilFuncionario : AppCompatActivity() {

    var imageBitMap: Bitmap? = null
    lateinit var trocarFoto_fun: TextView
    lateinit var imgFun: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_novo_perfil_funcionario)

        trocarFoto_fun = findViewById(R.id.trocar_fotoFunci)
        imgFun = findViewById(R.id.img_profileFun)

        trocarFoto_fun.setOnClickListener {
            abrirGaleria()
        }
    }
    private fun abrirGaleria() {

        val intent = Intent(Intent.ACTION_GET_CONTENT)

        intent.type = "image/*"
        startActivityForResult(
            Intent.createChooser(
                intent,
                "Escolha uma foto"
            ),
            CCODE_IMAGE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CCODE_IMAGE && resultCode == -1) {

            // Recuperar a imagem na stream
            val stream = contentResolver.openInputStream(data!!.data!!)

            // Transformar o resultado emn um BitMap
            imageBitMap = BitmapFactory.decodeStream(stream)

            // Colocar a imgaem no ImageView
            imgFun.setImageBitmap(imageBitMap)

            Log.i("xpto", converterBitmapParaBase64(imageBitMap!!))

//            trocarFotoPerfil()
        }
    }

}
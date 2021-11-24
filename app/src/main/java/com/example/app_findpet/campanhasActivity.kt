package com.example.app_findpet

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.app_findpet.utils.converterBitmapParaBase64

const val CODE_IMAGEE = 100
class campanhasActivity : AppCompatActivity() {

    var imageBitMap: Bitmap? = null
    lateinit var botao_add: Button
    lateinit var add_banner_imagem: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campanhas)

        botao_add = findViewById(R.id.botao_add_banner)
        add_banner_imagem = findViewById(R.id.add_banner)

        botao_add.setOnClickListener {
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
            CODE_IMAGEE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CODE_IMAGEE && resultCode == -1) {

            // Recuperar a imagem na stream
            val stream = contentResolver.openInputStream(data!!.data!!)

            // Transformar o resultado emn um BitMap
            imageBitMap = BitmapFactory.decodeStream(stream)

            // Colocar a imgaem no ImageView
            add_banner_imagem.setImageBitmap(imageBitMap)

            Log.i("xpto", converterBitmapParaBase64(imageBitMap!!))

//            trocarFotoPerfil()
        }
    }
}
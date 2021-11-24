package com.example.app_findpet

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.app_findpet.utils.converterBitmapParaBase64

const val CODEE_IMAGE = 100
class editarPerfilUsuarioActivity : AppCompatActivity() {

    var imageBitMap: Bitmap? = null
    lateinit var trocar_foto: TextView
    lateinit var imagem_perfil: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_perfil_usuario)

        trocar_foto = findViewById(R.id.tv_trocar_foto)
        imagem_perfil = findViewById(R.id.img_profile)

        trocar_foto.setOnClickListener {
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
            CODEE_IMAGE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CODEE_IMAGE && resultCode == -1) {

            // Recuperar a imagem na stream
            val stream = contentResolver.openInputStream(data!!.data!!)

            // Transformar o resultado emn um BitMap
            imageBitMap = BitmapFactory.decodeStream(stream)

            // Colocar a imgaem no ImageView
            imagem_perfil.setImageBitmap(imageBitMap)

            Log.i("xpto", converterBitmapParaBase64(imageBitMap!!))

//            trocarFotoPerfil()
        }
    }


}
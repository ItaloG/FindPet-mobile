package com.example.app_findpet.ui

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.app_findpet.utils.converterBitmapParaBase64
import com.google.android.material.textfield.TextInputEditText
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

const val CODE_IMAGEE = 100
class campanhasActivity : AppCompatActivity() {

    var imageBitMap: Bitmap? = null
    lateinit var botao_add: Button
    lateinit var add_banner_imagem: ImageView
    lateinit var data_inicio: TextInputEditText
    lateinit var data_termino: TextInputEditText
    lateinit var botaoEntrar: Button
    lateinit var tituloCampanha: EditText
    lateinit var descricaoCampanha: EditText
    lateinit var localCampanha: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campanhas)

        botao_add = findViewById(R.id.botao_add_banner)
        add_banner_imagem = findViewById(R.id.add_banner)
        data_inicio = findViewById(R.id.edit_text_data_inicio)
        data_termino = findViewById(R.id.edit_text_data_termino)
        botaoEntrar = findViewById(R.id.btn_entrar)
        tituloCampanha = findViewById(R.id.et_titulo_campanha)
        descricaoCampanha = findViewById(R.id.et_titulo_descricao_campanha)
        localCampanha = findViewById(R.id.et_local_descricao)

        botao_add.setOnClickListener {
            abrirGaleria()
        }

//        botaoEntrar.setOnClickListener {
//            val dados = getSharedPreferences("dados_usuario", Context.MODE_PRIVATE)
//
//            val editor = dados.edit()
//            editor.putString("titulo da campanha", tituloCampanha.toString())
//            editor.putString("descricao", descricaoCampanha.text.toString())
//            editor.putInt("local", localCampanha.text.toString().toInt())
//            editor.putInt("data inicio", data_inicio.text.toString().toInt())
//            editor.putInt("data termino", data_termino.text.toString().toInt())
//            editor.apply()
//        }

        // Criar um calendário
        val calendario = Calendar.getInstance()
        val ano = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        // Abrir um componente DatePickerDialog
        data_inicio.setOnClickListener {
            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{view, _ano, _mes, _dia ->
                    var diaZero = "$_dia"
                    var mesZero = "$_mes"

                    if (_dia < 10) {
                        diaZero = "0$_dia"
                    }

                    if (_mes < 9) {
                        mesZero = "0${_mes + 1}"
                    }
                    data_inicio.setText("$diaZero/$mesZero/$_ano")
                }, ano, mes, dia)
            dpd.show()
        }

        data_termino.setOnClickListener {
            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{view, _ano, _mes, _dia ->
                    var diaZero = "$_dia"
                    var mesZero = "$_mes"

                    if (_dia < 10) {
                        diaZero = "0$_dia"
                    }

                    if (_mes < 9) {
                        mesZero = "0${_mes + 1}"
                    }
                    data_termino.setText("$diaZero/$mesZero/$_ano")
                }, ano, mes, dia)
            dpd.show()
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
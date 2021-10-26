package com.example.app_findpet

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import com.example.app_findpet.utils.MaskFormatUtil

class tela_cadastro_instituicoes : AppCompatActivity() {

    lateinit var editTextCep: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro_instituicoes)

        supportActionBar!!.title = "Cadastro"

        editTextCep = findViewById(R.id.et_cep_instituicao)

        editTextCep.setOnFocusChangeListener { v, hasFocus ->
            val cep = MaskFormatUtil.unmask(editTextCep.text.toString())

            if (!hasFocus && cep.length == 8) {

            }
        }


    }
}

//Parte do checkBox
//fun onCheckboxClicked(view: View) {
//    if (view is CheckBox) {
//        val checked: Boolean = view.isChecked
//
//        when (view.id) {
//            R.id.checkbox_meat -> {
//                if (checked) {
//                    // Put some meat on the sandwich
//                } else {
//                    // Remove the meat
//                }
//            }
//        }
//    }
//}

//parte de trocar a imagem


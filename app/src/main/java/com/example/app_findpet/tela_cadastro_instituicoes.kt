package com.example.app_findpet

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import com.example.app_findpet.apiViacep.Cep
import com.example.app_findpet.apiViacep.RetrofitFactoryViacep
import com.example.app_findpet.utils.MaskFormatUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class tela_cadastro_instituicoes : AppCompatActivity() {

    lateinit var editTextCep: EditText
    lateinit var editTextRua: EditText
    lateinit var editTextTelefone: EditText
    lateinit var editTextCelular: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro_instituicoes)

        supportActionBar!!.title = "Cadastro"

        editTextCep = findViewById(R.id.et_cep_instituicao)
        editTextRua = findViewById(R.id.et_endereco_instituicao)
        editTextTelefone = findViewById(R.id.et_telefone_instituicao)
        editTextCelular = findViewById(R.id.et_celular_instituicao)


        editTextTelefone.addTextChangedListener(
            MaskFormatUtil.mask(
                editTextTelefone,
                MaskFormatUtil.FORMAT_FONE
            )
        )

        editTextCelular.addTextChangedListener(
            MaskFormatUtil.mask(
                editTextCelular,
                MaskFormatUtil.FORMAT_FONE_COD_AREA
            )
        )

        editTextCep.addTextChangedListener(
            MaskFormatUtil.mask(
                editTextCep,
                MaskFormatUtil.FORMAT_CEP
            )
        )

        editTextCep.setOnFocusChangeListener { v, hasFocus ->
            val cep = MaskFormatUtil.unmask(editTextCep.text.toString())

            if (!hasFocus && cep.length == 8) {
                buscarEndereco(cep)
            }
        }


    }

    private fun buscarEndereco(CEP: String) {

        val remote = RetrofitFactoryViacep().retrofitService()
        val call: Call<Cep> = remote.getCep(CEP)

        call.enqueue(object : Callback<Cep> {
            override fun onResponse(call: Call<Cep>, response: Response<Cep>) {
                val endereco = response.body()
                if (endereco != null) {
                    editTextRua.setText(endereco.logradouro)
                }
            }

            override fun onFailure(call: Call<Cep>, t: Throwable) {
                Log.i("cep", t.message.toString())
            }
        })
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


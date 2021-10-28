package com.example.app_findpet

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.app_findpet.apiFindpet.Instituicao
import com.example.app_findpet.apiFindpet.RetrofitFactoryFindpet
import com.example.app_findpet.apiViacep.Cep
import com.example.app_findpet.apiViacep.RetrofitFactoryViacep
import com.example.app_findpet.utils.MaskFormatUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class tela_cadastro_instituicoes : AppCompatActivity() {

    lateinit var editTextNome: EditText
    lateinit var spinnerTipoEstabelecimento: Spinner
    lateinit var editTextCnpj: EditText
    lateinit var editTextEmail: EditText
    lateinit var editTextSenha: EditText
    lateinit var editTextTelefone: EditText
    lateinit var editTextCelular: EditText
    lateinit var editTextCep: EditText
    lateinit var editTextRua: EditText
    lateinit var editTextNumero: EditText
    lateinit var editTextComplemento: EditText
    lateinit var buttonCadastrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro_instituicoes)

        supportActionBar!!.title = "Cadastro"

        editTextNome = findViewById(R.id.et_nome_instituicao)
        spinnerTipoEstabelecimento = findViewById(R.id.spinner_tipo_estabeleciamento)
        editTextCnpj = findViewById(R.id.et_cnpj)
        editTextEmail = findViewById(R.id.et_email_instituicao)
        editTextSenha = findViewById(R.id.et_senha_instituicao)
        editTextTelefone = findViewById(R.id.et_telefone_instituicao)
        editTextCelular = findViewById(R.id.et_celular_instituicao)
        editTextCep = findViewById(R.id.et_cep_instituicao)
        editTextRua = findViewById(R.id.et_endereco_instituicao)
        editTextNumero = findViewById(R.id.et_numero_instituicao)
        editTextComplemento = findViewById(R.id.et_comlemento_instituicao)
        buttonCadastrar = findViewById(R.id.botao_cadastro_instituicao)

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

        var nome = editTextNome.text
        var tipoEstabelecimento = spinnerTipoEstabelecimento.selectedItemPosition
        var cnpj = editTextCnpj.text
        var email = editTextEmail.text
        var senha = editTextSenha.text
        var telefone = editTextTelefone.text
        var celular = editTextCelular.text
        var cep = editTextCep.text
        var logradouro = editTextRua.text
        var numero = editTextNumero.text
        var complemento = editTextComplemento.text

        buttonCadastrar.setOnClickListener {
            criarInstituicao()
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

    private  fun criarInstituicao() {
        var instituicao =  Instituicao()

        instituicao.nome = editTextNome.text.toString()
        instituicao.tipoEstabelecimento = spinnerTipoEstabelecimento.selectedItemPosition
        instituicao.cnpj = editTextCnpj.text.toString()
        instituicao.email = editTextEmail.text.toString()
        instituicao.senha = editTextSenha.text.toString()
        instituicao.telefone = editTextTelefone.text.toString()
        instituicao.celular = editTextCelular.text.toString()
        instituicao.logradouro = editTextRua.text.toString()
        instituicao.cep = editTextCep.text.toString()
        instituicao.numero = editTextNumero.text.toString().toInt()
        instituicao.complemento = editTextComplemento.text.toString()

        val remote = RetrofitFactoryFindpet().retrofitServiceFindpet()
        val call: Call<Instituicao> = remote.criarInstituicao(instituicao)

        call.enqueue(object : Callback<Instituicao> {

            override fun onResponse(call: Call<Instituicao>, response: Response<Instituicao>) {
                val instituicao = response.body()

                Log.i("xpto", instituicao!!.nome)
            }

            override fun onFailure(call: Call<Instituicao>, t: Throwable) {
                val s = t.message
                Log.i("xpto", t.message.toString())
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


package com.example.app_findpet


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.example.app_findpet.apiFindpet.RetrofitFactoryFindpet
import com.example.app_findpet.apiFindpet.Usuario
import com.example.app_findpet.apiViacep.Cep
import com.example.app_findpet.apiViacep.RetrofitFactoryViacep
import com.example.app_findpet.utils.MaskFormatUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class tela_cadastro_usuarioComum : AppCompatActivity() {
    lateinit var editTextNome: EditText
    lateinit var editTextCpf: EditText
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
        setContentView(R.layout.activity_tela_cadastro_usuario_comum)

        supportActionBar!!.title = "Cadastro"

        editTextNome = findViewById(R.id.et_nome_usuario)
        editTextCpf = findViewById(R.id.et_cpf_usuario)
        editTextEmail = findViewById(R.id.et_email_usuario)
        editTextSenha = findViewById(R.id.et_senha_usuario)
        editTextTelefone = findViewById(R.id.et_telefone_usuario)
        editTextCelular = findViewById(R.id.et_celular_usuario)
        editTextCep = findViewById(R.id.et_cep_usuario)
        editTextRua = findViewById(R.id.et_endereco_usuario)
        editTextNumero = findViewById(R.id.et_numero_usuario)
        editTextComplemento = findViewById(R.id.et_comlemento_usuario)
        buttonCadastrar = findViewById(R.id.botao_cadastroUsu)

        editTextCpf.addTextChangedListener(
            MaskFormatUtil.mask(
                editTextCpf,
                MaskFormatUtil.FORMAT_CPF
            )
        )

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

        buttonCadastrar.setOnClickListener {
            criarUsuario()
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

    private fun abrirFeed() {
        val intent = Intent(this, tela_feed::class.java)
        startActivity(intent)
    }

    private fun criarUsuario() {
        var usuario = Usuario()

        usuario.nome = editTextNome.text.toString()
        usuario.cpf = editTextCpf.text.toString()
        usuario.email = editTextEmail.text.toString()
        usuario.senha = editTextSenha.text.toString()
        usuario.telefone = editTextTelefone.text.toString()
        usuario.celular = editTextCelular.text.toString()
        usuario.logradouro = editTextRua.text.toString()
        usuario.cep = editTextCep.text.toString()
        usuario.numero = editTextNumero.text.toString().toInt()
        usuario.complemento = editTextComplemento.text.toString()

        val remote = RetrofitFactoryFindpet().retrofitServiceFindpet()
        val call: Call<Usuario> = remote.criarUsuario(usuario)

        call.enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                val usuario = response.body()

                val dados = getSharedPreferences("dados_usuarios", Context.MODE_PRIVATE)
                val editor = dados.edit()

                editor.putString("nome", usuario!!.nome)
                editor.putString("cpf", usuario!!.cpf)
                editor.putString("email", usuario!!.email)
                editor.putString("senha", usuario!!.senha)
                editor.putString("telefone", usuario!!.telefone)
                editor.putString("celular", usuario!!.celular)
                editor.putString("logradouro", usuario!!.logradouro)
                editor.putString("cep", usuario!!.cep)
                editor.putInt("numero", usuario!!.numero)
                editor.putString("complemento", usuario!!.complemento)

                editor.apply()

                abrirFeed()

            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                Log.i("xpto", t.message.toString())
            }

        })
    }

}
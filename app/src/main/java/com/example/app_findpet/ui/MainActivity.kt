package com.example.app_findpet.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.app_findpet.classes.Login
import com.example.app_findpet.apiFindpet.RetrofitFactoryFindpet
import com.example.app_findpet.tela_escolha_cadastro
import com.example.app_findpet.tela_feed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var editTextEmail: EditText
    lateinit var editTextSenha: EditText
    lateinit var buttonCadastrar: Button
    lateinit var buttonEntrar: Button
    lateinit var buttonEnviarEsqueciSenha: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicio)

        supportActionBar!!.hide()

        editTextEmail = findViewById(R.id.et_email)
        editTextSenha = findViewById(R.id.et_senha)
        buttonCadastrar = findViewById(R.id.btn_cadastrar)
        buttonEntrar = findViewById(R.id.btn_entrar)
        buttonEnviarEsqueciSenha = findViewById(R.id.tv_esqueceu_senha)

        buttonEntrar.setOnClickListener {
            logar()
        }

        buttonCadastrar.setOnClickListener {
            val intent = Intent(this, tela_escolha_cadastro::class.java)
            startActivity(intent)

        }

        buttonEnviarEsqueciSenha.setOnClickListener {
            val intent = Intent(this, esqueciSenhaEtapa1Activity::class.java)
            startActivity(intent)
        }
    }

    private fun abrirFeed() {
        val intent = Intent(this, tela_feed::class.java)
        startActivity(intent)
    }

    private fun logar() {
        var login = Login()

        login.email = editTextEmail.text.toString()
        login.senha = editTextSenha.text.toString()

        val remote = RetrofitFactoryFindpet().retrofitServiceFindpet()
        val call: Call<Login> = remote.login(login)

        call.enqueue(object : Callback<Login> {
            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                val usuario = response.body()
                val dados = getSharedPreferences("dados_usuario", Context.MODE_PRIVATE)
                val editor = dados.edit()

                editor.putInt("id", usuario!!.id)
                editor.putString("nome", usuario.nome)
                editor.putString("cpf", usuario.cpf)
                editor.putString("cnpj", usuario.cnpj)
                editor.putInt("tipoEstabelecimento", usuario.tipoEstabelecimento)
                editor.putString("url_foto_perfil", usuario.url_foto_perfil)
                editor.putString("url_foto_banner", usuario.url_foto_banner)
                editor.putString("email", usuario.email)
                editor.putString("senha", usuario.senha)
                editor.putString("telefone", usuario.telefone)
                editor.putString("celular", usuario.celular)
                editor.putString("logradouro", usuario.logradouro)
                editor.putString("cep", usuario.cep)
                editor.putInt("numero", usuario.numero)
                editor.putString("complemento", usuario.complemento)
                editor.putString("tipo_usuario", usuario.tipo_usuario)
                editor.putString("descricao", usuario.descricao!!)
                editor.putString("token", usuario.token)

                editor.apply()

                abrirFeed()

            }

            override fun onFailure(call: Call<Login>, t: Throwable) {
                Log.i("xpto", t.message.toString())
            }

        })

    }
}


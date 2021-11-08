package com.example.app_findpet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.app_findpet.apiFindpet.Login
import com.example.app_findpet.apiFindpet.RetrofitFactoryFindpet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var editTextEmail: EditText
    lateinit var editTextSenha: EditText
    lateinit var buttonCadastrar: Button
    lateinit var buttonEntrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicio)

        supportActionBar!!.hide()

        editTextEmail = findViewById(R.id.et_email)
        editTextSenha = findViewById(R.id.et_senha)
        buttonCadastrar = findViewById(R.id.btn_cadastrar)
        buttonEntrar = findViewById(R.id.btn_entrar)

        buttonEntrar.setOnClickListener {
            logar()
        }

        buttonCadastrar.setOnClickListener {
            val intent = Intent(this, tela_escolha_cadastro::class.java)
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

                Log.i("xpto", usuario.toString())
            }

            override fun onFailure(call: Call<Login>, t: Throwable) {
                Log.i("xpto", t.message.toString())
            }

        })

    }
}


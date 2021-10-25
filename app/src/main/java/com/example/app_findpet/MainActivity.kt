package com.example.app_findpet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

    lateinit var buttonCadastrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicio)

        supportActionBar!!.hide()


        buttonCadastrar = findViewById(R.id.btn_cadastrar)

        buttonCadastrar.setOnClickListener {
            val intent = Intent(this, tela_escolha_cadastro::class.java)
            startActivity(intent)
        }
    }
}


package com.example.app_findpet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class tela_escolha_cadastro : AppCompatActivity() {

    lateinit var buttonCadastroInstituicao: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_escolha_cadastro)

        supportActionBar!!.hide()

        buttonCadastroInstituicao = findViewById(R.id.btn_cadsatrar_instituicao)

        buttonCadastroInstituicao.setOnClickListener {
            val intent = Intent(this, tela_cadastro_instituicoes::class.java)
            startActivity(intent)
        }

    }
}
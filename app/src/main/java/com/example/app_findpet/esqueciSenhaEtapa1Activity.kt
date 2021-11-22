package com.example.app_findpet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class esqueciSenhaEtapa1Activity : AppCompatActivity() {

    lateinit var buttonEnviarEsqueciSenha: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esqueci_senha_etapa1)

        supportActionBar!!.hide()

        buttonEnviarEsqueciSenha = findViewById(R.id.botao_cadastroIn)

        buttonEnviarEsqueciSenha.setOnClickListener {
            val intent = Intent(this, esqueciSenhaEtapa2Activity::class.java)
            startActivity(intent)
        }
    }
}
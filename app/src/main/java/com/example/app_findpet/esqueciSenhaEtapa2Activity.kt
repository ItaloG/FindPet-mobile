package com.example.app_findpet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class esqueciSenhaEtapa2Activity : AppCompatActivity() {

    lateinit var buttonEnviarEsqueciSenha: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esqueci_senha_etapa2)

            buttonEnviarEsqueciSenha = findViewById(R.id.botao_enviarEsqueciSenha)

            buttonEnviarEsqueciSenha.setOnClickListener {
                val intent = Intent(this, esqueciSenhaEtapa3Activity::class.java)
                startActivity(intent)
            }
    }
}
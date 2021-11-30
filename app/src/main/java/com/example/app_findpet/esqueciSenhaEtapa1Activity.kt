package com.example.app_findpet

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.app_findpet.utils.converterBitmapParaBase64

class esqueciSenhaEtapa1Activity : AppCompatActivity() {

    lateinit var buttonEnviarEsqueciSenha: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esqueci_senha_etapa1)

        buttonEnviarEsqueciSenha = findViewById(R.id.botao_cadastroIn)

        buttonEnviarEsqueciSenha.setOnClickListener {
            val intent = Intent(this, esqueciSenhaEtapa2Activity::class.java)
            startActivity(intent)
        }


    }
}
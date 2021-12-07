package com.example.app_findpet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.app_findpet.ui.tela_cadastro_usuarioComum

class tela_escolha_cadastro : AppCompatActivity() {

    lateinit var buttonCadastroInstituicao: Button
    lateinit var buttonCadastroUsuario: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_escolha_cadastro)

        supportActionBar!!.hide()

        buttonCadastroInstituicao = findViewById(R.id.btn_cadsatrar_instituicao)
        buttonCadastroUsuario = findViewById(R.id.btn_cadastro_usuario)

        buttonCadastroUsuario.setOnClickListener {
            val intent = Intent(this, tela_cadastro_usuarioComum::class.java)
            startActivity(intent)
        }


        buttonCadastroInstituicao.setOnClickListener {
            val intent = Intent(this, tela_cadastro_instituicoes::class.java)
            startActivity(intent)
        }

    }
}

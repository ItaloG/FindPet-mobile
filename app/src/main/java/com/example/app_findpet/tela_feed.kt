package com.example.app_findpet

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

class tela_feed : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_feed)

        supportActionBar!!.title = ""
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_teste, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_perfil -> {
                abrirPerfil()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun abrirPerfil() {
        val dados = getSharedPreferences("dados_usuario", Context.MODE_PRIVATE)

        val tipoUsuario = dados.getString("tipo_usuario", "")

        if (tipoUsuario == "comum") {
            val intent = Intent(this, tela_feed::class.java)
            startActivity(intent)
        } else if (tipoUsuario == "instituicao") {
            val intent = Intent(this, perfilInstituicaoVisaoInstituicaoActivity::class.java)
            startActivity(intent)
        } else {
            finish()
        }
    }
}
package com.example.app_findpet

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.app_findpet.ui.perfilInstituicaoVisaoInstituicaoActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class tela_feed : AppCompatActivity() {

    lateinit var navController : NavController
    lateinit var bot_navigation : BottomNavigationView
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_feed)

        navController = findNavController(R.id.hostFragment)
        bot_navigation = findViewById(R.id.bot_navigation)

        bot_navigation.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
       return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.bottom_menu, menu)
        return true
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
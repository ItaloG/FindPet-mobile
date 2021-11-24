package com.example.app_findpet

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.app_findpet.ui.perfilInstituicaoVisaoInstituicaoActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class tela_feed : AppCompatActivity() {

    //    lateinit var navController : NavController
    lateinit var bot_navigation: BottomNavigationView

    lateinit var animalPerdidoFragment: AnimalPerdidoFragment
    lateinit var favoritosFragment: FavoriteFragment
    lateinit var feedFragment: FeedFragment
    lateinit var mapaFragment: MapaFragment
    lateinit var sejaMenbroFragment: SejaMembroFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_feed)

        animalPerdidoFragment = AnimalPerdidoFragment()
        favoritosFragment = FavoriteFragment()
        feedFragment = FeedFragment()
        mapaFragment = MapaFragment()
        sejaMenbroFragment = SejaMembroFragment()

        bot_navigation = findViewById(R.id.bot_navigation)

        setFragment(feedFragment)

//        navController = findNavController(R.id.hostFragment)
//        bot_navigation.setupWithNavController(navController)
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fr_feed, fragment)
        fragmentTransaction.commit()
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
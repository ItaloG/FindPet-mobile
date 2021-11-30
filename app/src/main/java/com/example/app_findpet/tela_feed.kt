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
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_findpet.adapter.feedAdapter
import com.example.app_findpet.ui.perfilInstituicaoVisaoInstituicaoActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class tela_feed : AppCompatActivity() {


    lateinit var navController: NavController
    lateinit var bot_navigation: BottomNavigationView
    lateinit var appBarConfiguration: AppBarConfiguration


    //RecyclerView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: feedAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_feed)


        navController = findNavController(R.id.hostFragment)
        bot_navigation = findViewById(R.id.bot_navigation)

        bot_navigation.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupActionBarWithNavController(this, navController)

        recyclerView = findViewById(R.id.recyclerViewInstituicao)
        adapter = feedAdapter(this)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }


//        navController = findNavController(R.id.hostFragment)
//        bot_navigation.setupWithNavController(navController)
}

package com.example.app_findpet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class tela_campanhas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_campanhas)

        supportActionBar!!.title = "Nova Campanha"

        fun onCreateOptionsMenu(menu: Menu?): Boolean {
            val inflater = menuInflater
            inflater.inflate(R.menu.menu, menu)
            return true
        }

        fun onOptionsItemSelected(item: MenuItem): Boolean {

            return super.onOptionsItemSelected(item)
        }
    }
}
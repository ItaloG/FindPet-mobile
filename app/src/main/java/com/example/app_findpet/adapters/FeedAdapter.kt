 package com.example.app_findpet.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_findpet.R
import com.example.app_findpet.classes.Instituicao


class FeedAdapter(var context: Context) :
    RecyclerView.Adapter<FeedAdapter.InstituicaoViewHolder>() {

    private var listaInstituicao = emptyList<Instituicao>()

    fun updateListaInstituicao(lista: List<Instituicao>) {
        Log.i("xpto", "lista")
        listaInstituicao = lista
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstituicaoViewHolder {
        Log.i("xpto", "holder")
        val view =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.fragment_feed, parent, false)

        return InstituicaoViewHolder(view)
    }

    override fun onBindViewHolder(holder: InstituicaoViewHolder, position: Int) {
        Log.i("xpto", "bind")
        val instituicao = listaInstituicao[position]

        holder.titulo.text = instituicao.nome
    }

    override fun getItemCount(): Int {
        return listaInstituicao.size
    }

    class InstituicaoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titulo = itemView.findViewById<TextView>(R.id.tv_titutlo_card_instituicao)

    }
}
package com.example.app_findpet.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_findpet.R
import com.example.app_findpet.classes.Instituicao

class feedAdapter(var context: Context) :
    RecyclerView.Adapter<feedAdapter.InstituicaoViewHolder>() {

    private var listaInstituicao = emptyList<Instituicao>()

    fun updateListaInstituicao(lista: List<Instituicao>) {
        listaInstituicao = lista
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstituicaoViewHolder {
        val view =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.fragment_feed, parent, false)

        return InstituicaoViewHolder(view)
    }

    override fun onBindViewHolder(holder: InstituicaoViewHolder, position: Int) {
        val instituicao = listaInstituicao[position]

        holder.tituulo.text = instituicao.nome
    }

    override fun getItemCount(): Int {
        return listaInstituicao.size
    }

    class InstituicaoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tituulo = itemView.findViewById<TextView>(R.id.tv_titutlo_card_instituicao)

    }
}
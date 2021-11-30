package com.example.app_findpet.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_findpet.R
import com.example.app_findpet.classes.Servico

class ServicosAdapter(var context: Context) :
    RecyclerView.Adapter<ServicosAdapter.ServicoViewHolder>() {

    private var listaServicos = emptyList<Servico>()

    fun updateListaServicos(lista: List<Servico>) {
        Log.i("xpto", "lista")

        listaServicos = lista
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicoViewHolder {
        Log.i("xpto", "create")
        val view = LayoutInflater
            .from(context)
            .inflate(
                R.layout.servicos_reclycler_view_layout,
                parent,
                false
            )
        return ServicoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServicoViewHolder, position: Int) {
        val servico = listaServicos[position]

        Log.i("xpto", "holder")

        holder.tvServico.text = servico.servico
    }

    override fun getItemCount(): Int {

        return listaServicos.size
    }

    class ServicoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvServico = itemView.findViewById<TextView>(R.id.servico_item)
    }

}
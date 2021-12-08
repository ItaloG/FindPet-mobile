package com.example.app_findpet

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app_findpet.apiFindpet.RetrofitFactoryFindpet
import com.example.app_findpet.classes.Instituicao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FeedFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    private fun listarInstituicao() {

        val dados = getSharedPreferences("dados_usuario", Context.MODE_PRIVATE)
        val token = dados.getString("token", "")

        val remote = RetrofitFactoryFindpet().retrofitServiceFindpet()

        val call: Call<List<Instituicao>> = remote.listarInstituicao("Bearer $token")

        call.enqueue(object : Callback<List<Instituicao>> {

            override fun onResponse(
                call: Call<List<Instituicao>>,
                response: Response<List<Instituicao>>
            ) {
                val instituicao = response.body()

                feedAdapter.updateListaInstituicao(instituicao!!)
            }

            override fun onFailure(call: Call<List<Instituicao>>, t: Throwable) {
                Log.i("xpto", t.message.toString())
            }

        })
    }

}
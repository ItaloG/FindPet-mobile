package com.example.app_findpet


import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_findpet.adapters.FeedAdapter
import com.example.app_findpet.apiFindpet.RetrofitFactoryFindpet
import com.example.app_findpet.classes.Instituicao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedFragment : Fragment() {

    private lateinit var rcvFeed: RecyclerView
    private lateinit var feedAdapter: FeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    @Suppress("DEPRECATION")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context = view.context

        rcvFeed = view.findViewById(R.id.recyclerViewInstituicao)
        feedAdapter = FeedAdapter(context)
        rcvFeed.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rcvFeed.adapter = feedAdapter

        val dados = context.getSharedPreferences("dados_usuario", 0)
        val token = dados.getString("token", "")

        val remote = RetrofitFactoryFindpet().retrofitServiceFindpet()

        val call: Call<List<Instituicao>> = remote.listarInstituicao("Bearer $token")

        call.enqueue(object : Callback<List<Instituicao>> {
            override fun onResponse(
                call: Call<List<Instituicao>>,
                response: Response<List<Instituicao>>
            ) {
                Log.i("xpto", "listei")
                //feedAdapter.updateListaInstituicao(response.body()!!)
            }

            override fun onFailure(call: Call<List<Instituicao>>, t: Throwable) {
                Log.i("xpto", t.message.toString())
            }

        })

    }

//    private fun listarInstituicao() {
//
//        val dados = this.activity?.getSharedPreferences("dados_usuario", Context.MODE_PRIVATE)
//        val token = dados?.getString("token", "")
//
//        val remote = RetrofitFactoryFindpet().retrofitServiceFindpet()
//
//        val call: Call<List<Instituicao>> = remote.listarInstituicao("Bearer $token")
//
//        call.enqueue(object : Callback<List<Instituicao>> {
//
//            override fun onResponse(
//                call: Call<List<Instituicao>>,
//                response: Response<List<Instituicao>>
//            ) {
//                val instituicao = response.body()
//
//                feedAdapter.
//            }
//
//            override fun onFailure(call: Call<List<Instituicao>>, t: Throwable) {
//                Log.i("xpto", t.message.toString())
//            }
//
//        })
//    }

}
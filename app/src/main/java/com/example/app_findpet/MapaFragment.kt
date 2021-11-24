package com.example.app_findpet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app_findpet.databinding.FragmentMapaBinding


class MapaFragment : Fragment() {

    lateinit var binding: FragmentMapaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapaBinding.inflate(inflater)
        return binding.root
    }

}
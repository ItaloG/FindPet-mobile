package com.example.app_findpet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app_findpet.databinding.FragmentSejaMembroBinding


class SejaMembroFragment : Fragment() {


    lateinit var binding: FragmentSejaMembroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSejaMembroBinding.inflate(inflater)
        return binding.root
    }


}
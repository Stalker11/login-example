package com.example.loginapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginapp.databinding.FragmentSecondNameBinding

class SecondNameFragment:BaseFragment() {
    private lateinit var binding: FragmentSecondNameBinding
    companion object {
        fun newInstance(): SecondNameFragment {
            return SecondNameFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondNameBinding.inflate(inflater, container, false)
        return binding.root
    }

}
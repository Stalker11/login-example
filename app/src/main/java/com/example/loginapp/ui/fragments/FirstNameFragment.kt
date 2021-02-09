package com.example.loginapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginapp.databinding.FragmentFirstNameBinding

//https://www.raywenderlich.com/142-android-custom-view-tutorial#toc-anchor-012
class FirstNameFragment : BaseFragment() {
    private lateinit var binding: FragmentFirstNameBinding

    companion object {
        val FRAGMENT_FIRST_EXTRA = "FRAGMENT_FIRST_EXTRA"
        val PUT_BUNDLE_EXTRA = "PUT_BUNDLE_EXTRA"
        fun newInstance(data: String): FirstNameFragment {
            return FirstNameFragment().apply {
                setArguments(Bundle().apply {
                    putString(FRAGMENT_FIRST_EXTRA, data)
                })
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstNameBinding.inflate(inflater, container, false)
        arguments?.getString(FRAGMENT_FIRST_EXTRA,"empty")
        return binding.root
    }
}
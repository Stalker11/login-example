package com.example.loginapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.loginapp.BaseActivity
import com.example.loginapp.databinding.ActivityViewPager2Binding
import com.example.loginapp.ui.fragments.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerActivity: BaseActivity() {
    private val binding by lazy { ActivityViewPager2Binding.inflate(layoutInflater) }

    companion object {
        val PUT_EXTRA_USER_DATA = "PUT_EXTRA_USER_DATA"
        fun newInstance(context: Context): Intent {
            return Intent(context, ViewPagerActivity::class.java).apply {
              //  putExtra(PUT_EXTRA_USER_DATA, users)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
       // Log.d("TAG", "onCreate: ${binding.root} ${intent?.extras?.getParcelable<UserModel>(PUT_EXTRA_USER_DATA)}")
        val adapters = ViewPagerAdapter(this)
        binding.viewPager2.adapter = adapters

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            position
        }.attach()
    }
}
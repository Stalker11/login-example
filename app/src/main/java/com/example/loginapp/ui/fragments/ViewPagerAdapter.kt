package com.example.loginapp.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
//https://github.com/AdrianKuta/ViewPagerDotsIndicator/blob/master/app/src/main/java/com/adriankuta/viewpagerdots/activities/ViewPager2Activity.kt
class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }
//1 set up for testing
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return FirstNameFragment.newInstance("Test string")
            }
            1 -> {
                return SecondNameFragment.newInstance()
            }
        }
        return Fragment()
    }
}
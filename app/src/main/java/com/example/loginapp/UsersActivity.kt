package com.example.loginapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.loginapp.databinding.ActivityUsersBinding

class UsersActivity: BaseActivity() {

    private val binding by lazy { ActivityUsersBinding.inflate(layoutInflater) }

    companion object {
        fun newInstance(context: Context): Intent {
            return Intent(context, UsersActivity::class.java)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
package com.example.loginapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginapp.databinding.ActivityUsersBinding
import com.example.loginapp.di.ServiceLocatorImpl
import com.example.loginapp.ui.ClickRecyclerListener
import com.example.loginapp.ui.UsersAdapter
import com.example.loginapp.utils.Constants
import com.example.loginapp.viewmodels.UsersViewModel
import com.example.loginapp.viewmodels.ViewModelFactory
import com.example.signin.net.models.usermodel.UserNWModel

class UsersActivity : BaseActivity(), ClickRecyclerListener {

    private val binding by lazy { ActivityUsersBinding.inflate(layoutInflater) }
    private val serviceLocator by lazy { ServiceLocatorImpl() }
    private val usersViewModel by lazy { ViewModelFactory(serviceLocator).create(UsersViewModel::class.java) }
    private lateinit var adapter: UsersAdapter
    private val layoutManager by lazy { LinearLayoutManager(this) }

    companion object {
        fun newInstance(context: Context): Intent {
            return Intent(context, UsersActivity::class.java)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getSharedPreferences(Constants.SH_NAME, MODE_PRIVATE).getString(Constants.SAVE_TOKEN, "")
            ?.let { usersViewModel.getUsersList(2, it) }

        usersViewModel.usersList.observe(this, {
            adapter = UsersAdapter(it) {
                when (it.userId) {
                    -1 -> {
                        startActivity(Intent(Intent.ACTION_VIEW).apply {
                            data = Uri.parse(it.supportUrl)
                        })
                    }
                    else -> {
                        showErrorDialog(it.firstName)
                    }
                }

            }
            binding.usersList.adapter = adapter
            binding.usersList.layoutManager = layoutManager
        })
    }

    override fun onItemClick(model: UserNWModel) {

    }
}
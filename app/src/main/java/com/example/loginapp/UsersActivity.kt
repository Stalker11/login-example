package com.example.loginapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginapp.databinding.ActivityUsersBinding
import com.example.loginapp.di.ServiceLocatorImpl
import com.example.loginapp.ui.ClickRecyclerListener
import com.example.loginapp.ui.deviders.CustomDevider
import com.example.loginapp.ui.UsersAdapter
import com.example.loginapp.ui.ViewPagerActivity
import com.example.loginapp.ui.models.UserModel
import com.example.loginapp.ui.paginator.PaginationListener
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
    //TODO Different layoutManagers
    //private val layoutManager by lazy { GridLayoutManager(this, 3) }
    private var currentPage = 1
    private var isLoading: Boolean = false
    private var usersModel: MutableList<UserModel> = mutableListOf()


    companion object {
        fun newInstance(context: Context): Intent {
            return Intent(context, UsersActivity::class.java)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getSharedPreferences(Constants.SH_NAME, MODE_PRIVATE).getString(Constants.SAVE_TOKEN, "")
            ?.let { usersViewModel.getUsersList(currentPage, it) }

        usersViewModel.usersList.observe(this, {
            usersModel = it
            //TODO Must be deleted after debugging pagination
            Handler(Looper.getMainLooper()).postDelayed({
                isLoading = false
                adapter.updateUsersList(usersModel)
            },2000)
        })
        adapter = UsersAdapter{
            when (it.userId) {
                -1 -> {
                    startActivity(Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse(it.supportUrl)
                    })
                }
                else -> {
                    //showErrorDialog(it.firstName)
                    startActivity(ViewPagerActivity.newInstance(this, it))
                }
            }

        }
        val itemDecorator = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        ContextCompat.getDrawable(this,R.drawable.recycler_devider)?.let {
            itemDecorator.setDrawable(
                it
            )
        }
       // binding.usersList.addItemDecoration(itemDecorator)
        binding.usersList.addItemDecoration(CustomDevider(this, R.drawable.recycler_devider))
        binding.usersList.adapter = adapter
        binding.usersList.layoutManager = layoutManager
        binding.usersList.addOnScrollListener(PaginationRecyclerView(layoutManager))
    }

    override fun onItemClick(model: UserNWModel) {

    }

    private fun loadMore() {
        //Comment for testing
        getSharedPreferences(Constants.SH_NAME, MODE_PRIVATE).getString(Constants.SAVE_TOKEN, "")
            ?.let { usersViewModel.getUsersList(currentPage, it) }
        adapter.isLoading(true)
    }

    inner class PaginationRecyclerView(layoutManager: LinearLayoutManager) :
        PaginationListener(layoutManager) {
        override fun loadMoreItems() {
            isLoading = true
            currentPage += 1
            loadMore()
        }

        override fun getTotalPageCount(): Int? {
            return if (usersModel.isNotEmpty() == true) {
                usersModel.get(0).totalPages
            } else {
                0
            }
        }

        override fun isLastPage(): Boolean {
            return if (usersModel.isNotEmpty() == true) {
                usersModel.get(0).totalPages == currentPage
            } else {
                false
            }
        }

        override fun isLoading(): Boolean {
           return isLoading
        }

    }
}
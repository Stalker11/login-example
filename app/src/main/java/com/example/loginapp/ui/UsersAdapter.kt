package com.example.loginapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.loginapp.databinding.ItemSupportBinding
import com.example.loginapp.databinding.ItemUserBinding
import com.example.loginapp.ui.models.UserModel
import com.example.loginapp.ui.viewholders.SupportViewHolder
import com.example.loginapp.ui.viewholders.UsersViewHolder

class UsersAdapter(val models: MutableList<UserModel>, private val callback: (UserModel) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val SUPPORT_VIEW = 1001
    private val USER_VIEW = 1003

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       if (viewType == USER_VIEW) {
           val holder = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
           return UsersViewHolder(holder)
       }else{
           val holder = ItemSupportBinding.inflate(LayoutInflater.from(parent.context), parent, false)
           return SupportViewHolder(holder)
       }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            USER_VIEW -> {
                (holder as UsersViewHolder).bind(models[position])
                holder.itemView.setOnClickListener {
                    //listener.onItemClick(models[position])
                    callback.invoke(models[position])
                }
            }
            SUPPORT_VIEW -> {
                (holder as SupportViewHolder).bind(models[position])
                holder.itemView.setOnClickListener {
                    callback.invoke(models[position])
                }

            }
        }

    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun getItemViewType(position: Int): Int {
        if (position == (models.size - 1)) {
            return SUPPORT_VIEW
        } else {
            return USER_VIEW
        }

    }
}
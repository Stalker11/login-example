package com.example.loginapp.ui.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.loginapp.databinding.ItemSupportBinding
import com.example.loginapp.ui.models.UserModel

class SupportViewHolder(val binding: ItemSupportBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(user: UserModel){
        binding.itemSupportText.text = user.supportDescription
    }
}
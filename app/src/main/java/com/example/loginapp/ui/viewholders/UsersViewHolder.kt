package com.example.loginapp.ui.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.loginapp.databinding.ItemUserBinding
import com.example.loginapp.ui.models.UserModel
import com.squareup.picasso.Picasso

class UsersViewHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(user: UserModel){
        Picasso.get().load(user.userAvatar).into(binding.userAvatarImage)
        binding.userItemFirstName.text = user.firstName
        binding.userItemSecondName.text = user.secondName
    }
}
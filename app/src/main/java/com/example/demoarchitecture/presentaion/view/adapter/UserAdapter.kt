package com.example.demoarchitecture.presentaion.view.adapter

// UserAdapter.kt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoarchitecture.R
import com.example.demoarchitecture.data.model.UserModel

class UserAdapter(private val users: List<UserModel>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        var emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
        var avatarImageView: ImageView = itemView.findViewById(R.id.avatarImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.apply {
            nameTextView.text = "${user.firstName} ${user.lastName}"
            emailTextView.text = user.email
            Glide.with(holder.itemView.context).load(user.avatar).into(avatarImageView)
        }
    }

    override fun getItemCount(): Int = users.size
}

package com.example.application_dagger_hilt_retrofit.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.application_dagger_hilt_retrofit.R
import com.example.application_dagger_hilt_retrofit.data.model.ResponseUser
import com.example.application_dagger_hilt_retrofit.data.model.User
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(
    private val user: ArrayList<User>,
    private val onClick: ItemListener? = null
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) {
            val fullName = itemView.textViewUserName
            fullName.text = user.first_name + " " + user.last_name
            itemView.textViewUserEmail.text = user.email
            Glide.with(itemView.imageViewAvatar.context)
                .load(user.avatar)
                .into(itemView.imageViewAvatar)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )


    override fun getItemCount(): Int = user.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onClick?.onClick(user[position])
        }
        holder.bind(user[position])
    }

    fun addData(list: List<User>) {
        user.addAll(list)
    }
    fun clearAndData(list: List<User>) {
        user.clear()
        user.addAll(list)
    }



}




package com.example.application_dagger_hilt_retrofit.ui.main.adapter

import com.example.application_dagger_hilt_retrofit.data.model.User

interface ItemListener {

    fun onClick(itemUser: User)
}
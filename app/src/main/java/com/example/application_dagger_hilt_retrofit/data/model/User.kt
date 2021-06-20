package com.example.application_dagger_hilt_retrofit.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("first_name")
    val first_name: String? = null,
    @SerializedName("last_name")
    val last_name: String ? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("avatar")
    val avatar: String? = null
)
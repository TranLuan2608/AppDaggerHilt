package com.example.application_dagger_hilt_retrofit.data.model

import com.squareup.moshi.Json

data class User(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "first_name")
    val first_name: String = "",
    @Json(name = "last_name")
    val last_name: String = "",
    @Json (name = "email")
    val email: String = "",
    @Json(name = "avatar")
    val avatar: String = ""
)
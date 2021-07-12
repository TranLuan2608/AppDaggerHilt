package com.example.application_dagger_hilt_retrofit.data.model

import com.google.gson.annotations.SerializedName
data class ResponseUser(
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val per_page: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("data")
    val data: List<User>



)


package com.example.application_dagger_hilt_retrofit.data.api

import com.example.application_dagger_hilt_retrofit.data.model.ResponseUser
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("users")
    suspend fun getUser(@Query("page") page: Int): Response<ResponseUser>

}
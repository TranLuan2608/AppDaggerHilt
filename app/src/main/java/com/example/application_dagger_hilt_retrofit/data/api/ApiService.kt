package com.example.application_dagger_hilt_retrofit.data.api

import com.example.application_dagger_hilt_retrofit.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("user")
    suspend fun getUser(): Response<List<User>>

}
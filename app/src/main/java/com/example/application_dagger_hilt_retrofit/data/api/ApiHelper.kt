package com.example.application_dagger_hilt_retrofit.data.api

import com.example.application_dagger_hilt_retrofit.data.model.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getUser(): Response<List<User>>
}
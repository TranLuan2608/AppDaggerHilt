package com.example.application_dagger_hilt_retrofit.data.api

import com.example.application_dagger_hilt_retrofit.data.model.ResponseUser
import retrofit2.Response

interface ApiHelper {

    suspend fun getUser(page: Int): Response<ResponseUser>
}
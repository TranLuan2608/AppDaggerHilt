package com.example.application_dagger_hilt_retrofit.data.api

import com.example.application_dagger_hilt_retrofit.data.model.ResponseUser
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
     suspend fun getUser(): Response<ResponseUser>
     fun getApi(@Query("page")key: String): Call<ResponseUser>

}
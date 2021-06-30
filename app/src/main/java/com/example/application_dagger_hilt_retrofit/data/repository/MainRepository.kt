package com.example.application_dagger_hilt_retrofit.data.repository

import com.example.application_dagger_hilt_retrofit.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getUsers() =  apiHelper.getUser()


}
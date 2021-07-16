package com.example.application_dagger_hilt_retrofit.ui.main.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application_dagger_hilt_retrofit.data.model.User
import com.example.application_dagger_hilt_retrofit.data.repository.MainRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AddUserViewModel @ViewModelInject constructor(
    private val mainRepository : MainRepository
) : ViewModel() {
     private var count: Int = 0
    fun countUsers(): Int
    {
        viewModelScope.launch {
            mainRepository.getUsersLocal().collect {
                 var countUser: Int = it.size
                 count = countUser++
            }
        }
        return count
    }

    fun addDataUser(dataUser: User)
    {
        viewModelScope.launch {
            mainRepository.addUser(dataUser)
        }
    }


}
package com.example.application_dagger_hilt_retrofit.ui.main.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.application_dagger_hilt_retrofit.data.model.User
import com.example.application_dagger_hilt_retrofit.data.repository.MainRepository
import com.example.application_dagger_hilt_retrofit.utils.NetworkHelper
import com.example.application_dagger_hilt_retrofit.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(

    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper

    ) : ViewModel()
    {

        private val _user = MutableLiveData<Resource<List<User>>>()
        val user: LiveData<Resource<List<User>>>
            get() = _user

        init {
            fetchUser()
        }

        private fun fetchUser() {
            viewModelScope.launch {
                _user.postValue(Resource.loading(null))
                if (networkHelper.isNetworkConnected()) {
                    mainRepository.getUsers().let {
                        if (it.isSuccessful) {
                            _user.postValue(Resource.success(it.body()?.data))
                        } else _user.postValue(Resource.error(it.errorBody().toString(), null))
                    }
                } else _user.postValue(Resource.error("No internet connection", null))
            }
        }
    }
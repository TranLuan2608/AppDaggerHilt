package com.example.application_dagger_hilt_retrofit.ui.main.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.application_dagger_hilt_retrofit.data.model.User
import com.example.application_dagger_hilt_retrofit.data.repository.MainRepository
import com.example.application_dagger_hilt_retrofit.utils.NetworkHelper
import com.example.application_dagger_hilt_retrofit.utils.Resource
import kotlinx.coroutines.flow.collect
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
            Log.d("luan 3","luan")
            fetchUser(1)
        }

        fun fetchUser(page: Int) {
            viewModelScope.launch {
                _user.postValue(Resource.loading(null))
                if (networkHelper.isNetworkConnected()) {
                    Log.d("luan 2","luan" )
                    mainRepository.getUsers(page).let {
                        if (it.isSuccessful) {
                            _user.postValue(Resource.success(it.body()?.data))
                        } else _user.postValue(Resource.error(it.errorBody().toString(), null))
                    }
                } else {
                        mainRepository.getUsersLocal().collect {
                            Log.d("luan 8","luan" + it.size)
                            _user.postValue(Resource.success(it))
                        }
                }
            }
        }
    }
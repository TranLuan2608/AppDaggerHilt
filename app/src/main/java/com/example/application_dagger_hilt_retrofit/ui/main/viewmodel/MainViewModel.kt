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
            //run code phia trong voi mot luong la viewModelScope
            viewModelScope.launch {
                _user.postValue(Resource.loading(null))
                //kiểm tra internet
                if (networkHelper.isNetworkConnected()) {
                    Log.d("luan 2","luan" )
                    //lay du lieu tu api
                    mainRepository.getUsers(page).let {
                        //kiem tra viec lay du lieu
                        if (it.isSuccessful) {
                            //tra du lieu ve
                            _user.postValue(Resource.success(it.body()?.data))
                        } else _user.postValue(Resource.error(it.errorBody().toString(), null))
                    }
                } else {
                    //lay du lieu tu database
                    mainRepository.getUsersLocal().collect {
                        Log.d("luan 8","luan" + it.size)
                        //tra du lieu ve
                        _user.postValue(Resource.success(it))
                    }
                }
            }
        }


        fun fetchNameUser(userFirstName: String, userLastName: String){
            viewModelScope.launch {
                if(userFirstName.equals(userLastName,true))
                {
                    //lay du lieu tu database
                    mainRepository.getUserByName(userFirstName,userLastName).collect { users ->
                        Log.d("luan 9","luan$users")
                        //tra du lieu ve
                        _user.postValue(Resource.success(users))

                    }
                }else {
                    //lay du lieu tu database
                    mainRepository.getUserByFullName(userFirstName, userLastName).collect { users ->
                        Log.d("luan 9", "luan$users")
                        //tra du lieu ve
                        _user.postValue(Resource.success(users))

                    }
                }


            }
        }
    }
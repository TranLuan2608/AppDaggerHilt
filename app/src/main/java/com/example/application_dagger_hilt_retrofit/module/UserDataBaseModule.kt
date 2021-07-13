package com.example.application_dagger_hilt_retrofit.module

import android.content.Context
import com.example.application_dagger_hilt_retrofit.data.model.UserDao
import com.example.application_dagger_hilt_retrofit.data.model.UserDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@InstallIn(Singleton::class)
@Module
class UserDataBaseModule {
    @Provides
    fun providerUserDataBase(context: Context): UserDataBase {
        return UserDataBase.getInstance(context)
    }

    @Provides
    fun providerUserDataDAO(context: Context): UserDao {
        return UserDataBase.getInstance(context).userDao()
    }
}
package com.example.application_dagger_hilt_retrofit.data.repository
import com.example.application_dagger_hilt_retrofit.data.api.ApiHelper
import com.example.application_dagger_hilt_retrofit.data.model.UserDataBase
import com.example.application_dagger_hilt_retrofit.utils.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper,
    private val db: UserDataBase
    ) {

    private val userDao = db.userDao()
    suspend fun getUsers(page: Int) = networkBoundResource(
        query = {
            userDao.getAllUser()
        },
        fetch = {
            delay(2000)
            apiHelper.getUser(page)
        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                userDao.deleteAllUser()
                userDao.insertUsers(restaurants)
            }
        }
    )
}
package com.example.application_dagger_hilt_retrofit.data.repository
import android.util.Log
import com.example.application_dagger_hilt_retrofit.data.api.ApiHelper
import com.example.application_dagger_hilt_retrofit.data.model.ResponseUser
import com.example.application_dagger_hilt_retrofit.data.model.User
import com.example.application_dagger_hilt_retrofit.data.model.UserDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flowOf
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper,
    private val db: UserDataBase
    ) {

    private val userDao = db.userDao()

    suspend fun getUsers(page: Int): Response<ResponseUser> {
        val data = apiHelper.getUser(page)
        Log.d("luan 7","luan" + data.body()?.data)
        data.body()?.data?.let { userDao.insertUsers(it) }
        return data
    }

    suspend fun addUser(addDataUser: User)
    {
         userDao.insertUser(addDataUser)
    }

    fun getUsersLocal(): Flow<List<User>> {
        val data = userDao.getAllUser()
        return data
    }

    fun getUserByName(userFirstName: String, userLastName: String): Flow<List<User>>
    {
        val userName = userDao.getUserByName(userFirstName,userLastName)
        return userName
    }
    fun getUserByFullName(userFirstName: String, userLastName: String): Flow<List<User>>
    {
        val userFullName = userDao.getUserByFullName(userFirstName,userLastName)
        return userFullName
    }
//        networkBoundResource(
//
//        query = {
//            Log.d("luan","luan" )
//            userDao.getAllUser()
//        },
//        fetch = {
//            delay(2000)
//            Log.d("luan","luan" )
//            apiHelper.getUser(page)
//        },
//        saveFetchResult = { data ->
//            db.withTransaction {
//                userDao.deleteAllUser()
//                Log.d("luan","luan" )
//                data.body()?.data?.let { userDao.insertUsers(it) }
//            }
//        }
//    )
}
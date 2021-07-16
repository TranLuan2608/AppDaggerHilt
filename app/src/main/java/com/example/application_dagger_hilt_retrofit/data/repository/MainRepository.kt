package com.example.application_dagger_hilt_retrofit.data.repository
import com.example.application_dagger_hilt_retrofit.data.api.ApiHelper
import com.example.application_dagger_hilt_retrofit.data.model.ResponseUser
import com.example.application_dagger_hilt_retrofit.data.model.User
import com.example.application_dagger_hilt_retrofit.data.model.UserDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper,
    private val db: UserDataBase
    ) {

    private val userDao = db.userDao()

    suspend fun getUsers(page: Int): Response<ResponseUser> {
        val data = apiHelper.getUser(page)
        data.body()?.data?.let { userDao.insertUsers(it) }
        return data
    }

    suspend fun addUser(addDataUser: User) = flow{
        userDao.insertUser(addDataUser)
        emit(true)
    }


    fun getUsersLocal(): Flow<List<User>> {
        return userDao.getAllUser()
    }

    fun getUserByName(userFirstName: String, userLastName: String): Flow<List<User>> {
        return userDao.getUserByName(userFirstName, userLastName)
    }
    fun getUserByFullName(userFirstName: String, userLastName: String): Flow<List<User>> {
        return userDao.getUserByFullName(userFirstName, userLastName)
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
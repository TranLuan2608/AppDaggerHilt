package com.example.application_dagger_hilt_retrofit.data.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

@Dao
abstract class UserDao {
    @Query("SELECT * FROM user_table" )
    abstract fun getAllUser(): Flow<List<User>>
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertUsers(user: List<User>)
    @Query("DElETE FROM user_table")
    abstract suspend fun deleteAllUser()
    @Query("SELECT * FROM user_table WHERE first_name LIKE :userFirstName Or last_name LIKE :userLastName" )
    abstract fun getUserByName(userFirstName: String, userLastName: String): Flow<List<User>>
    @Query("SELECT * FROM user_table WHERE first_name LIKE :userFirstName AND last_name LIKE :userLastName" )
    abstract fun getUserByFullName(userFirstName: String, userLastName: String): Flow<List<User>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //suspend fun co kha nang start, pause, resume giup thread khong gap tinh trang blocking
    abstract suspend fun insertUser(user: User)


}
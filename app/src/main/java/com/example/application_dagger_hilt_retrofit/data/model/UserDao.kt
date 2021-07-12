package com.example.application_dagger_hilt_retrofit.data.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
abstract class UserDao {
    @Query("SELECT * FROM user_table" )
    abstract fun getAllUser(): Flow<List<User>>
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertUsers(User: List<User>)
    @Query("DElETE FROM user_table")
    abstract suspend fun deleteAllUser()
}
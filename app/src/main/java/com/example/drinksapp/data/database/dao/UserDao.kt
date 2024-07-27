package com.example.drinksapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.drinksapp.data.database.entities.UserEntity
import com.example.drinksapp.util.Constants

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM ${Constants.DATABASE_USER_TABLE} WHERE id=:userId")
    suspend fun getUser(userId: String): UserEntity

}
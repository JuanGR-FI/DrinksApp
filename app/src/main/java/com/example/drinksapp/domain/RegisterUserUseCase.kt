package com.example.drinksapp.domain

import android.util.Base64
import com.example.drinksapp.data.DrinkRepository
import com.example.drinksapp.data.database.entities.UserEntity
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(private val repository: DrinkRepository) {

    suspend fun insertUser(username: String, passwd: String) {
        val encodingPassword =
            Base64.encode(passwd.toByteArray(), Base64.DEFAULT)
                .toString(Charsets.UTF_8)

        val userEntity = UserEntity(name = username, password = encodingPassword)

        repository.insertUser(userEntity)

    }

}
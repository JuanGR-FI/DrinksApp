package com.example.drinksapp.domain

import android.util.Base64
import com.example.drinksapp.data.DrinkRepository
import com.example.drinksapp.domain.model.User
import com.example.drinksapp.data.model.UserProvider
import com.example.drinksapp.domain.model.toDomain
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val repository: DrinkRepository) {

    suspend fun getUserByName(username: String, passwd: String): User? {
        val response = repository.getUserByNameFromDatabase(username)

        if (response != null) {
            val user = response.toDomain()

            if (validateUser(user, passwd)) {
                return user
            }
        }

        return null

    }

    private fun validateUser(user: User, passwd: String): Boolean =
        (decodePassword(user.password) == passwd)

    private fun decodePassword(passwd: String) =
        Base64.decode(passwd, Base64.DEFAULT).toString(Charsets.UTF_8)

    /*var encodingPassword =
        Base64.encode(etPassword.text.toString().trim().toByteArray(), Base64.DEFAULT)
            .toString(Charsets.UTF_8)*/

}
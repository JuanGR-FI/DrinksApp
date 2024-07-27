package com.example.drinksapp.domain

import android.util.Base64
import com.example.drinksapp.data.model.User
import com.example.drinksapp.data.model.UserProvider
import javax.inject.Inject

class GetUserUseCase @Inject constructor() {

    fun validateUser(username: String, password: String): User? {
        var currentUser: User? = null

        val listFilter = UserProvider.users.filter { it.name == username }

        currentUser = if (listFilter.isEmpty()) {
            null
        } else {
            listFilter[0]
        }

        if (currentUser != null) {
            return if (password == decodePassword(currentUser.password)) {
                currentUser
            } else {
                null
            }

        }
        return null
    }

    private fun decodePassword(passwd: String) =
        Base64.decode(passwd, Base64.DEFAULT).toString(Charsets.UTF_8)

    /*var encodingPassword =
        Base64.encode(etPassword.text.toString().trim().toByteArray(), Base64.DEFAULT)
            .toString(Charsets.UTF_8)*/

}
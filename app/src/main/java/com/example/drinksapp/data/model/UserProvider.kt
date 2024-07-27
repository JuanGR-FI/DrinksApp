package com.example.drinksapp.data.model

import com.example.drinksapp.domain.model.User

class UserProvider {
    companion object {
        var users: List<User> = listOf(User(0, "Juan", "TWF0ZW1hdGljYXMxLg=="))
    }
}
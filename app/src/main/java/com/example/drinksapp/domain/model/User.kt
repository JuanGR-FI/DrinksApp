package com.example.drinksapp.domain.model

import com.example.drinksapp.data.database.entities.UserEntity

data class User(
    val id: Int,
    val name: String,
    val password: String
)

fun UserEntity.toDomain() = User(
    id,
    name,
    password
)

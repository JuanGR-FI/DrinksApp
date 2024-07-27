package com.example.drinksapp.data

import com.example.drinksapp.data.database.dao.DrinkDao
import com.example.drinksapp.data.database.dao.UserDao
import com.example.drinksapp.data.database.entities.DrinkEntity
import com.example.drinksapp.data.database.entities.UserEntity
import com.example.drinksapp.data.model.DrinkModel
import com.example.drinksapp.data.model.toDomain
import com.example.drinksapp.data.network.DrinkService
import com.example.drinksapp.domain.model.Drink
import com.example.drinksapp.domain.model.toDomain
import javax.inject.Inject

class DrinkRepository @Inject constructor(
    private val api: DrinkService,
    private val userDao: UserDao,
    private val drinkDao: DrinkDao
) {

    suspend fun getUserByIdFromDatabase(id: Int): UserEntity {
        val response = userDao.getUserById(id)
        return response
    }

    suspend fun getUserByNameFromDatabase(username: String): UserEntity {
        val response = userDao.getUserByName(username)
        return response
    }

    suspend fun getAllDrinks(letter: Char): List<DrinkModel> {
        val response = api.getDrinks(letter)
        //QuoteProvider.quotes = response
        return response
        //return response.map { it.toDomain() }
    }

    suspend fun getDrinkDetail(id: Int): List<DrinkModel> {
        val response = api.getDrinkDetail(id)
        //QuoteProvider.quotes = response
        return response
        //return response.map { it.toDomain() }
    }

    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun insertFavorite(drink: DrinkEntity){
        drinkDao.insertFavorite(drink)
    }

    suspend fun getAllFavorites(userId: Int): List<DrinkModel>{
        val response = drinkDao.getAllFavorites(userId)

        return response.map { it.toDomain() }
    }

}
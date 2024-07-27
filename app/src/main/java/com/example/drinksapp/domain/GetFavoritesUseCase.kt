package com.example.drinksapp.domain

import com.example.drinksapp.data.DrinkRepository
import com.example.drinksapp.data.model.DrinkModel
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(private val repository: DrinkRepository) {

    suspend fun getFavorites(userId: Int): List<DrinkModel> {
        val response = repository.getAllFavorites(userId)

        return response
    }

}
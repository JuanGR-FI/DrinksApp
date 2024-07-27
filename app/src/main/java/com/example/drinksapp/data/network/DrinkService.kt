package com.example.drinksapp.data.network

import com.example.drinksapp.data.model.DrinkModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DrinkService @Inject constructor(
    private val api: DrinkApiClient
) {

    suspend fun getDrinks(letter: Char): List<DrinkModel> {

        return withContext(Dispatchers.IO) {
            val response = api.getDrinks(letter)
            response.body()?.drinks ?: emptyList()
        }
    }

    suspend fun getDrinkDetail(id: Int): List<DrinkModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getDrinkDetail(id)
            response.body()?.drinks ?: emptyList()
        }
    }

}
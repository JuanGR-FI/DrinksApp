package com.example.drinksapp.data

import com.example.drinksapp.data.model.Drink
import com.example.drinksapp.data.network.DrinkService
import javax.inject.Inject

class DrinkRepository @Inject constructor(
    private val api: DrinkService
) {

    suspend fun getAllDrinks(letter: Char): List<Drink> {
        val response = api.getDrinks(letter)
        //QuoteProvider.quotes = response
        return response
    }

    suspend fun getDrinkDetail(id: Int): List<Drink> {
        val response = api.getDrinkDetail(id)
        //QuoteProvider.quotes = response
        return response
    }

}
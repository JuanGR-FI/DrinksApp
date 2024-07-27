package com.example.drinksapp.domain

import com.example.drinksapp.data.DrinkRepository
import com.example.drinksapp.data.model.DrinkModel
import com.example.drinksapp.domain.model.Drink
import javax.inject.Inject

class GetDrinksByLetterUseCase @Inject constructor(
    private val repository: DrinkRepository
) {

    suspend fun getDrinksByLetter(letter: Char): List<Drink> = repository.getAllDrinks(letter)

}
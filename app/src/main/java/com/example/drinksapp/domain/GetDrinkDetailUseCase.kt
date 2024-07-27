package com.example.drinksapp.domain

import com.example.drinksapp.data.DrinkRepository
import com.example.drinksapp.data.model.DrinkModel
import com.example.drinksapp.domain.model.Drink
import javax.inject.Inject

class GetDrinkDetailUseCase @Inject constructor(
    private val repository: DrinkRepository
) {

    suspend fun getDrinkDetail(id: Int): List<Drink> = repository.getDrinkDetail(id)
}
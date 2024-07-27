package com.example.drinksapp.data.network

import androidx.lifecycle.findViewTreeLifecycleOwner
import com.example.drinksapp.core.RetrofitHelper
import com.example.drinksapp.data.model.Drink
import com.example.drinksapp.data.model.DrinkModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import javax.inject.Inject

class DrinkService @Inject constructor(
    private val api: DrinkApiClient
) {

    suspend fun getDrinks(letter: Char): List<Drink> {

        return withContext(Dispatchers.IO) {
            val response = api.getDrinks(letter)
            response.body()?.drinks ?: emptyList()
        }
    }

    suspend fun getDrinkDetail(id: Int): List<Drink> {
        return withContext(Dispatchers.IO) {
            val response = api.getDrinkDetail(id)
            response.body()?.drinks ?: emptyList()
        }
    }

}
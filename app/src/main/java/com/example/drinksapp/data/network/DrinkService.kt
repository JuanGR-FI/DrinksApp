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

class DrinkService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getDrinks(letter: Char): List<Drink> {

        return withContext(Dispatchers.IO) {
            /*val call: Call<DrinkModel> = retrofit.create(DrinkApiClient::class.java).getDrinks('a')
            var drinkResponse = emptyList<Drink>()

            call.enqueue(object : Callback<DrinkModel> {
                override fun onResponse(call: Call<DrinkModel>, response: Response<DrinkModel>) {
                    if (response.body() != null) {
                        drinkResponse = response.body()!!.drinks
                    }

                }

                override fun onFailure(call: Call<DrinkModel>, t: Throwable) {
                    drinkResponse = emptyList()
                }

            })
            drinkResponse*/
            val response = retrofit.create(DrinkApiClient::class.java).getDrinks(letter)
            response.body()?.drinks ?: emptyList()
        }
    }

}
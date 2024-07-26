package com.example.drinksapp.data.network

import com.example.drinksapp.data.model.DrinkModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkApiClient {

    @GET("search.php")
    suspend fun getDrinks(
        @Query("f") letter: Char
    ): Response<DrinkModel>
}
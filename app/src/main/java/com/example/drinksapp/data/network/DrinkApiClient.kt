package com.example.drinksapp.data.network

import com.example.drinksapp.data.model.DrinkModelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkApiClient {

    @GET("search.php")
    suspend fun getDrinks(
        @Query("f") letter: Char
    ): Response<DrinkModelResponse>

    @GET("lookup.php")
    suspend fun getDrinkDetail(
        @Query("i") id: Int
    ): Response<DrinkModelResponse>

}
package com.example.drinksapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.drinksapp.data.database.entities.DrinkEntity
import com.example.drinksapp.util.Constants

@Dao
interface DrinkDao {

    @Query("SELECT * FROM ${Constants.DATABASE_FAVORITE_TABLE}")
    suspend fun getAllFavorites(): List<DrinkEntity>

    @Insert
    suspend fun insertFavorite(drinkEntity: DrinkEntity)

}
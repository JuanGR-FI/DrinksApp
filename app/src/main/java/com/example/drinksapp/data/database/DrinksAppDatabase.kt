package com.example.drinksapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.drinksapp.data.database.dao.DrinkDao
import com.example.drinksapp.data.database.dao.UserDao
import com.example.drinksapp.data.database.entities.DrinkEntity
import com.example.drinksapp.data.database.entities.UserEntity

@Database(entities = [DrinkEntity::class, UserEntity::class], version = 1, exportSchema = false)
abstract class DrinksAppDatabase : RoomDatabase() {

    abstract fun getDrinkDao(): DrinkDao

    abstract fun getUserDao(): UserDao

}
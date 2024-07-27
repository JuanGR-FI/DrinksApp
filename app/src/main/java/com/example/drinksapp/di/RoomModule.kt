package com.example.drinksapp.di

import android.content.Context
import androidx.room.Room
import com.example.drinksapp.data.database.DrinksAppDatabase
import com.example.drinksapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, DrinksAppDatabase::class.java, Constants.DATABASE_NAME)
            .build()

    @Singleton
    @Provides
    fun provideDrinkDao(db: DrinksAppDatabase) = db.getDrinkDao()

    @Singleton
    @Provides
    fun provideUserDao(db: DrinksAppDatabase) = db.getUserDao()

}
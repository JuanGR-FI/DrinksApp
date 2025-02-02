package com.example.drinksapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drinksapp.data.model.DrinkModel
import com.example.drinksapp.domain.GetDrinkDetailUseCase
import com.example.drinksapp.domain.GetDrinksByLetterUseCase
import com.example.drinksapp.domain.GetFavoritesUseCase
import com.example.drinksapp.domain.InsertDrinkToDbUseCase
import com.example.drinksapp.domain.model.Drink
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrinkViewModel @Inject constructor(
    private val getDrinksByLetterUseCase: GetDrinksByLetterUseCase,
    private val getDrinkDetailUseCase: GetDrinkDetailUseCase,
    private val insertDrinkToDbUseCase: InsertDrinkToDbUseCase,
    private val getFavoritesUseCase: GetFavoritesUseCase
) : ViewModel() {

    private val _drinkList = MutableLiveData<List<DrinkModel>>()
    val drinkList: LiveData<List<DrinkModel>> = _drinkList

    private val _drink = MutableLiveData<DrinkModel>()
    val drink: LiveData<DrinkModel> = _drink

    private val _favDrinkList = MutableLiveData<List<DrinkModel>>()
    val favDrinkList: LiveData<List<DrinkModel>> = _favDrinkList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getDrinks(index: Int) {
        viewModelScope.launch {
            _isLoading.postValue(true)
            val result = getDrinksByLetterUseCase
                .getDrinksByLetter(getNewLetter(index))

            if (!result.isNullOrEmpty()) {
                _drinkList.postValue(result)
                _isLoading.postValue(false)
            }
        }
    }

    fun getDrinkDetail(id: Int) {
        viewModelScope.launch {
            _isLoading.postValue(true)
            val result = getDrinkDetailUseCase
                .getDrinkDetail(id)

            if (!result.isNullOrEmpty()) {
                _drink.postValue(result[0])
                _isLoading.postValue(false)
            }
        }
    }

    fun insertFavorite(drink: DrinkModel, userId: Int) {
        viewModelScope.launch {
            insertDrinkToDbUseCase.insertFavorite(drink, userId)
        }
    }

    fun getFavorites(userId: Int) {
        viewModelScope.launch {
            _isLoading.postValue(true)
            val result = getFavoritesUseCase.getFavorites(userId)
            _favDrinkList.postValue(result)
            _isLoading.postValue(false)
        }

    }


    private fun getNewLetter(index: Int): Char {
        return when (index) {
            0 -> 'a'
            1 -> 'b'
            2 -> 'c'
            3 -> 'd'
            4 -> 'e'
            5 -> 'f'
            6 -> 'g'
            7 -> 'h'
            8 -> 'i'
            9 -> 'j'
            10 -> 'k'
            11 -> 'l'
            12 -> 'm'
            13 -> 'n'
            14 -> 'o'
            15 -> 'p'
            16 -> 'q'
            17 -> 'r'
            18 -> 's'
            19 -> 't'
            20 -> 'u'
            21 -> 'v'
            22 -> 'w'
            23 -> 'x'
            24 -> 'y'
            25 -> 'z'
            else -> 'a'

        }
    }

}
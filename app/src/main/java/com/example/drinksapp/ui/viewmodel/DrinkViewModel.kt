package com.example.drinksapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drinksapp.data.model.Drink
import com.example.drinksapp.domain.GetDrinksByLetterUseCase
import kotlinx.coroutines.launch

class DrinkViewModel : ViewModel() {
    private val _drinkList = MutableLiveData<List<Drink>>()
    val drinkList: LiveData<List<Drink>> = _drinkList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getDrinks(letter: Char) {
        viewModelScope.launch {
            _isLoading.postValue(true)
            val result = GetDrinksByLetterUseCase().getDrinksByLetter('a')

            if (!result.isNullOrEmpty()) {
                _drinkList.postValue(result)
                _isLoading.postValue(false)
            }
        }

    }

}
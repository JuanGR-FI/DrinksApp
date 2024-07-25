package com.example.drinksapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.drinksapp.data.model.User

class UserViewModel : ViewModel() {

    private val _isNameValid = MutableLiveData<Boolean>()
    val isNameValid: LiveData<Boolean> = _isNameValid

    private val _isPasswordValid = MutableLiveData<Boolean>()
    val isPasswordValid: LiveData<Boolean> = _isPasswordValid

    fun validateFields(username: String, password: String) {
        if (username.isEmpty()) {
            _isNameValid.postValue(false)
        }
        if (password.isEmpty()) {
            _isPasswordValid.postValue(false)
        }

        if(username.isNotEmpty() && password.isNotEmpty())
            getUser(username, password)

    }

    private fun getUser(username: String, password: String): User? {
        return null
    }

}
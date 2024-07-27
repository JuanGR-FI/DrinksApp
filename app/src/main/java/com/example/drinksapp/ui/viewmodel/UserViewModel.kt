package com.example.drinksapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.drinksapp.domain.model.User
import com.example.drinksapp.domain.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _isNameValid = MutableLiveData<Boolean>()
    val isNameValid: LiveData<Boolean> = _isNameValid

    private val _isPasswordValid = MutableLiveData<Boolean>()
    val isPasswordValid: LiveData<Boolean> = _isPasswordValid

    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    fun validateFields(username: String, password: String) {
        if (username.isEmpty()) {
            _isNameValid.postValue(false)
        }
        if (password.isEmpty()) {
            _isPasswordValid.postValue(false)
        }

        if (username.isNotEmpty() && password.isNotEmpty()) {
            val userResult = getUser(username, password)
            _user.postValue(userResult)
        }

    }

    private fun getUser(username: String, password: String): User? {
        val currentUser = getUserUseCase.validateUser(username, password)
        return currentUser
    }

}
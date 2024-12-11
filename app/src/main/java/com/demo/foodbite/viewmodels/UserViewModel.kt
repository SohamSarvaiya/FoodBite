package com.demo.foodbite.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    var username by mutableStateOf("")
    var email by mutableStateOf("")
    var dob by mutableStateOf("")
    var password by mutableStateOf("")
    var confirmPassword by mutableStateOf("")
}


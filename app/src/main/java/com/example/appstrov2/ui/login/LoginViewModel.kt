package com.example.appstrov2.ui.login

import androidx.lifecycle.ViewModel
import com.example.appstrov2.data.Repository

class LoginViewModel(private val storyRepo: Repository): ViewModel() {
    fun postLogin(email: String, pass: String) = storyRepo.login(email, pass)
}
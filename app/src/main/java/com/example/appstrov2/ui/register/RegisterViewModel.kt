package com.example.appstrov2.ui.register

import androidx.lifecycle.ViewModel
import com.example.appstrov2.data.Repository

class RegisterViewModel(private val storyRepo: Repository): ViewModel() {
    fun register(name: String, email: String, pw: String) =
        storyRepo.register(name, email, pw)
}
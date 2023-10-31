package com.example.appstrov2

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appstrov2.data.Repository
import com.example.appstrov2.di.Injection
import com.example.appstrov2.ui.login.LoginViewModel
import com.example.appstrov2.ui.register.RegisterViewModel

class ViewModelFactory private constructor(private val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                return LoginViewModel(repository) as T
            }
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                return RegisterViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.repositoryProvide(context))
            }.also { instance = it }
    }

}
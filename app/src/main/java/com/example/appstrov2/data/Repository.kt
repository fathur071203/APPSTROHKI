package com.example.appstrov2.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData

import com.example.appstrov2.response.Login
import com.example.appstrov2.response.Register
import com.example.appstrov2.retrofit.ApiService


class Repository(
    private val apiService: ApiService
) {
    fun login(email: String, pw: String) : LiveData<Result<Login>> = liveData {
        emit(Result.Loading)
        try {
            val response = apiService.login(email, pw)
            emit(Result.Success(response))
        }
        catch (e: Exception){
            emit(Result.Error(e.message.toString()))

        }
    }

    fun register(name: String, email: String, pw: String) : LiveData<Result<Register>> = liveData {
        emit(Result.Loading)
        try {
            val response = apiService.register(name, email, pw)
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }

    }
}
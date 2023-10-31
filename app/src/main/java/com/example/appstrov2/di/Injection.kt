package com.example.appstrov2.di

import android.content.Context
import com.example.appstrov2.data.Repository
import com.example.appstrov2.retrofit.ApiConfig

object Injection {
    fun repositoryProvide(context: Context) : Repository {

        val apiService = ApiConfig.getApiService()
        return Repository(apiService)
    }
}
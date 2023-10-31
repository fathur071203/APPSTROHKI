package com.example.appstrov2.data

import android.content.Context

internal class UserPreferences(context: Context) {

    private val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun getUserPreferences() : Username {
        return Username(sharedPreferences.getString(TOKEN, "") ?: "")
    }

    fun setUserPreferences(user: Username)  {
        sharedPreferences.edit().putString(TOKEN, user.tokenName).apply()
    }

    companion object {
        private const val PREFS_NAME = "user_pref"
        private const val TOKEN = "token"
    }
}
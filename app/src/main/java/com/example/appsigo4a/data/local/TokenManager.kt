package com.example.appsigo4a.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit

import android.content.SharedPreferences

class TokenManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("sigo_prefs", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        prefs.edit().putString("token", token).apply()
    }

    fun getToken(): String? {
        return prefs.getString("token", null)
    }

    fun clearToken() {
        prefs.edit().remove("token").apply()
    }
    fun getFullName(): String? {
        return prefs.getString("full_name", "")
    }

    fun getUsername(): String? {
        return prefs.getString("username", "")
    }
}

package com.example.appsigo4a.data.local

import android.content.Context
import android.content.SharedPreferences

class TokenManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("sigo_prefs", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        prefs.edit().putString("token", token).apply()
    }

    fun getToken(): String? = prefs.getString("token", null)

    fun clearToken() {
        prefs.edit().clear().apply()
    }

    fun saveUserData(fullName: String, username: String, email: String, profile: String) {
        prefs.edit()
            .putString("full_name", fullName)
            .putString("username", username)
            .putString("email", email)
            .putString("profile", profile)
            .apply()
    }

    fun getFullName(): String? = prefs.getString("full_name", "")
    fun getUsername(): String? = prefs.getString("username", "")
    fun getEmail(): String? = prefs.getString("email", "")
    fun getProfile(): String? = prefs.getString("profile", "")
}

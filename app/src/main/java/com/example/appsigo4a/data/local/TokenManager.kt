package com.example.appsigo4a.data.local

import android.content.Context
import android.content.SharedPreferences

class TokenManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("sigo_prefs", Context.MODE_PRIVATE)

    // ===============================
    // Token
    // ===============================
    fun saveToken(token: String) {
        prefs.edit().putString("token", token).apply()
    }

    fun getToken(): String? = prefs.getString("token", null)

    fun clearToken() {
        prefs.edit().clear().apply()
    }

    // ===============================
    // Datos básicos del usuario
    // ===============================
    fun saveUserData(
        fullName: String,
        username: String,
        email: String,
        profile: String
    ) {
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

    // ===============================
    // Datos extra (lo que pidió el profe)
    // ===============================
    fun saveExtraUserData(
        module: String,
        registerDate: String
    ) {
        prefs.edit()
            .putString("module", module)
            .putString("register_date", registerDate)
            .apply()
    }

    fun getModule(): String? = prefs.getString("module", "")
    fun getRegisterDate(): String? = prefs.getString("register_date", "")
}

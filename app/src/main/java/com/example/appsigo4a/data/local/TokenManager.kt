package com.example.appsigo4a.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.appsigo4a.data.model.UserResponse

class TokenManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("sigo_prefs", Context.MODE_PRIVATE)

    // -------------------------
    // TOKEN
    // -------------------------
    fun saveToken(token: String) {
        prefs.edit().putString("token", token).apply()
    }

    fun getToken(): String? = prefs.getString("token", null)

    fun clearToken() {
        prefs.edit().clear().apply()
    }

    // -------------------------
    // SAVE USER FROM RESPONSE
    // -------------------------
    fun saveUserResponse(data: UserResponse) {
        prefs.edit()
            .putString("person_full_name", data.personFullName)
            .putString("username", data.username)
            .putString("email", data.email)
            .putString("profile_name", data.profileName)
            .putStringSet("roles", data.roles.toSet())
            .putString("register_user", data.registerUser)
            .putString("register", data.register)
            .putBoolean("active", data.active)
            .putBoolean("terms_conditions", data.termsConditions)
            .putString("token", data.bearer)
            .apply()
    }

    // -------------------------
    // GETTERS
    // -------------------------
    fun getPersonFullName(): String? = prefs.getString("person_full_name", "")
    fun getUsername(): String? = prefs.getString("username", "")
    fun getEmail(): String? = prefs.getString("email", "")
    fun getProfileName(): String? = prefs.getString("profile_name", "")
    fun getRoles(): List<String> = prefs.getStringSet("roles", emptySet())!!.toList()
    fun getRegisterUser(): String? = prefs.getString("register_user", "")
    fun getRegister(): String? = prefs.getString("register", "")
    fun isActive(): Boolean = prefs.getBoolean("active", false)
    fun hasAcceptedTerms(): Boolean = prefs.getBoolean("terms_conditions", false)
}
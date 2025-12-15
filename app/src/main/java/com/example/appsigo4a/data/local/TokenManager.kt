package com.example.appsigo4a.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.appsigo4a.data.model.UserResponse

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

    // GUARDAR TODO EL JSON DEL USUARIO
    fun saveUser(user: UserResponse) {
        prefs.edit()
            .putString("full_name", user.personFullName)
            .putString("username", user.username)
            .putString("email", user.email)
            .putString("profile_name", user.profileName)
            .putString("access_module", user.accessModule)
            .putBoolean("active", user.active)
            .putString("register", user.register)
            .apply()
    }

    fun getFullName(): String? = prefs.getString("full_name", "")
    fun getUsername(): String? = prefs.getString("username", "")
    fun getEmail(): String? = prefs.getString("email", "")
    fun getProfileName(): String? = prefs.getString("profile_name", "")
    fun getAccessModule(): String? = prefs.getString("access_module", "")
    fun isActive(): Boolean = prefs.getBoolean("active", false)
    fun getRegisterDate(): String? = prefs.getString("register", "")
}


package com.example.appsigo4a.data

import android.content.Context

class SessionManager(context: Context) {

    private val prefs = context.getSharedPreferences(
        "sigo_session",
        Context.MODE_PRIVATE
    )

    fun guardarSesionActiva(activa: Boolean) {
        prefs.edit().putBoolean("sesion_activa", activa).apply()
    }

    fun haySesionActiva(): Boolean {
        return prefs.getBoolean("sesion_activa", false)
    }

    fun cerrarSesion() {
        prefs.edit().clear().apply()
    }
}



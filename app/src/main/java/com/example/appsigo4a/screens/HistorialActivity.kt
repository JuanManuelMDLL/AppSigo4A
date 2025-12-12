package com.example.appsigo4a.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.appsigo4a.ui.theme.AppSigo4ATheme

class HistorialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppSigo4ATheme {
                // Pasamos un onLogoutClick en blanco ya que no necesitamos hacer nada en esta actividad por ahora
                HistorialScreen(onLogoutClick = { /* Acción de cerrar sesión */ })
            }
        }
    }
}

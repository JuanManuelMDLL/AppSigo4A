package com.example.appsigo4a.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.appsigo4a.ui.theme.AppSigo4ATheme

class PerfilActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppSigo4ATheme {
                // Pasamos el onLogoutClick al PerfilScreen
                PerfilScreen(onLogoutClick = { /* Acción de cerrar sesión */ })
            }
        }
    }
}


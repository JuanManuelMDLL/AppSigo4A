package com.example.appsigo4a.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.appsigo4a.MainActivity
import com.example.appsigo4a.ui.theme.AppSigo4ATheme

class PerfilActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppSigo4ATheme {
                PerfilScreen(
                    onLogout = {
                        // Acción al cerrar sesión
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish() // Evita volver con botón atrás
                    }
                )
            }
        }
    }
}

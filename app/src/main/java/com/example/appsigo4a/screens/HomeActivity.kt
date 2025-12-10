package com.example.appsigo4a.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appsigo4a.ui.theme.AppSigo4ATheme

class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppSigo4ATheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // 1. Crear el controlador de navegación
                    val navController = rememberNavController()

                    // 2. Definir el mapa de navegación
                    NavHost(navController = navController, startDestination = "dashboard_screen") {

                        // Ruta 1: Pantalla Principal (Dashboard)
                        composable("dashboard_screen") {
                            DashboardScreen(navController)
                        }

                        // Ruta 2: Pantalla de Perfil
                        composable("profile_screen") {
                            ProfileScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
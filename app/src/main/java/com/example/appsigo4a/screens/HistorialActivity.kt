package com.example.appsigo4a.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appsigo4a.ui.theme.AppSigo4ATheme

class HistorialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppSigo4ATheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "historial") {
                    composable("historial") {
                        HistorialScreen(
                            onLogoutClick = { /* Acción de cerrar sesión */ },
                            onVerCalificacionesClick = {
                                navController.navigate("calificaciones")
                            }
                        )
                    }
                    composable("calificaciones") {
                        CalificacionesScreen(
                            onBackClick = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}

package com.example.appsigo4a.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appsigo4a.ui.theme.AppSigo4ATheme
import android.content.Intent

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppSigo4ATheme {
                // Usamos el navController aquí para gestionar la navegación
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(
                            onPerfilClick = {
                                val intent = Intent(this@HomeActivity, PerfilActivity::class.java)
                                startActivity(intent)
                            },
                            onHistorialClick = {
                                val intent = Intent(this@HomeActivity, HistorialActivity::class.java)
                                startActivity(intent)
                            },
                            onLogoutClick = {
                                // Navegar a la pantalla de login usando Jetpack Compose
                                navController.navigate("login") {
                                    popUpTo("home") { inclusive = true }
                                }
                            }
                        )
                    }
                    composable("login") {
                        LoginScreen(
                            onLoginSuccess = {
                                navController.navigate("home") {
                                    popUpTo("login") { inclusive = true }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

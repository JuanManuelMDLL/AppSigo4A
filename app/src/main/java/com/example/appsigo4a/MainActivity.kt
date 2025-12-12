package com.example.appsigo4a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appsigo4a.screens.HomeScreen
import com.example.appsigo4a.screens.LoginScreen
import com.example.appsigo4a.screens.PerfilScreen
import com.example.appsigo4a.screens.HistorialScreen
import com.example.appsigo4a.screens.CalificacionesScreen
import com.example.appsigo4a.ui.theme.AppSigo4ATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppSigo4ATheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {


        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }


        composable("home") {
            HomeScreen(
                onPerfilClick = { navController.navigate("perfil") },
                onHistorialClick = { navController.navigate("historial") },
                onLogoutClick = {
                    navController.navigate("login") {
                        popUpTo("home") { inclusive = true }
                    }
                }
            )
        }


        composable("perfil") {
            PerfilScreen(
                onLogoutClick = {
                    navController.navigate("login") {
                        popUpTo("perfil") { inclusive = true }
                    }
                }
            )
        }


        composable("historial") {
            HistorialScreen(
                onLogoutClick = {
                    navController.navigate("login") {
                        popUpTo("historial") { inclusive = true }
                    }
                },
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
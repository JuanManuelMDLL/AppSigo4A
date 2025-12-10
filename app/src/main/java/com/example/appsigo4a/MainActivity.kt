package com.example.appsigo4a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.lifecycle.lifecycleScope
import com.example.appsigo4a.data.*
import com.example.appsigo4a.screens.*
import com.example.appsigo4a.ui.theme.AppSigo4ATheme
import kotlinx.coroutines.launch
import androidx.activity.compose.BackHandler


class MainActivity : ComponentActivity() {

    private lateinit var repositorio: Repositorio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repositorio = Repositorio(this)

        // ✅ SIMULAMOS DATOS DE SIGO Y LOS GUARDAMOS EN ROOM
        lifecycleScope.launch {
            val alumno = Alumno(
                id = 1,
                nombre = "Juan Manuel",
                apellido = "Molina De La Luz",
                matricula = "UTM2025",
                carrera = "Ingeniería en Software",
                correo = "juan.molina@utm.edu.mx"
            )

            val calificaciones = listOf(
                Calificacion(materia = "Programación", calificacion = 9, cuatrimestre = "4°"),
                Calificacion(materia = "Bases de Datos", calificacion = 8, cuatrimestre = "4°"),
                Calificacion(materia = "Redes", calificacion = 9, cuatrimestre = "4°")
            )

            repositorio.guardarAlumno(alumno)
            repositorio.guardarCalificaciones(calificaciones)
        }

        setContent {

            val sessionManager = SessionManager(this)

            var pantalla by remember {
                mutableStateOf(
                    if (sessionManager.haySesionActiva()) "home" else "login"
                )
            }

            AppSigo4ATheme {

                // ✅ Back seguro SIN finish() forzado
                BackHandler(enabled = pantalla != "login") {
                    when (pantalla) {
                        "historial", "perfil" -> pantalla = "home"
                        "home" -> pantalla = "login"
                    }
                }

                when (pantalla) {

                    "login" -> LoginScreen {
                        sessionManager.guardarSesionActiva(true)
                        pantalla = "home"
                    }

                    "home" -> HomeScreen(
                        onHistorialClick = { pantalla = "historial" },
                        onPerfilClick = { pantalla = "perfil" },
                        onLogout = {
                            sessionManager.cerrarSesion()
                            pantalla = "login"
                        }
                    )

                    "historial" -> HistorialScreen(repositorio)

                    "perfil" -> PerfilScreen(repositorio)
                }
            }
        }


    }
}


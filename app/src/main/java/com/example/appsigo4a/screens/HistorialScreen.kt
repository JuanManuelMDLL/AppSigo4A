package com.example.appsigo4a.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appsigo4a.data.Calificacion
import com.example.appsigo4a.data.Repositorio
import kotlinx.coroutines.launch

@Composable
fun HistorialScreen(repositorio: Repositorio) {

    var lista by remember { mutableStateOf<List<Calificacion>>(emptyList()) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            lista = repositorio.obtenerCalificacionesLocal()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // ====== TÍTULO ======
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Historial Académico",
                style = MaterialTheme.typography.headlineMedium
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ====== SI NO HAY DATOS ======
        if (lista.isEmpty()) {
            Text("No hay calificaciones registradas.")
        } else {

            // ====== LISTA DE MATERIAS ======
            LazyColumn {
                items(lista) { calificacion ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {

                            Text(
                                text = calificacion.materia,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Text("Cuatrimestre: ${calificacion.cuatrimestre}")
                            Text("Calificación: ${calificacion.promedio}")
                            Text("Estado: ${calificacion.estado}")

                        }
                    }
                }
            }
        }
    }
}

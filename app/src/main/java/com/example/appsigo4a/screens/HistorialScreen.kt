package com.example.appsigo4a.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.random.Random

// -------------------- MODELOS --------------------

data class Materia(
    val nombre: String,
    val parcial1: Int,
    val parcial2: Int,
    val parcial3: Int,
    val maestro: String
) {
    val final: Int
        get() = (parcial1 + parcial2 + parcial3) / 3
}

data class Cuatrimestre(
    val nombre: String,
    val estado: String,
    val carrera: String,
    val grupo: String,
    val tutor: String,
    val progreso: Int,
    val materias: List<Materia>
)

// -------------------- HELPERS --------------------

private fun calificacion(): Int = Random.nextInt(7, 11)

private fun letra(calificacion: Int): String =
    when (calificacion) {
        10 -> "E"
        9 -> "A"
        8 -> "B"
        else -> "R"
    }

// -------------------- SCREEN --------------------

@Composable
fun HistorialScreen(
    onLogoutClick: () -> Unit
) {

    val cuatrimestres = remember {
        listOf(
            Cuatrimestre(
                "1er Cuatrimestre",
                "Finalizado",
                "Tecnologías de la Información",
                "1A Matutino",
                "Dra. Gricelda Rodríguez Robledo",
                100,
                listOf(
                    Materia("Inglés I", calificacion(), calificacion(), calificacion(), "Lic. María Verónica"),
                    Materia("Fundamentos de Programación", calificacion(), calificacion(), calificacion(), "I.T.I Julio César Correa")
                )
            ),
            Cuatrimestre(
                "2do Cuatrimestre",
                "Finalizado",
                "Tecnologías de la Información",
                "2A Matutino",
                "Dra. Olga Leticia Robles García",
                100,
                listOf(
                    Materia("Cálculo Diferencial", calificacion(), calificacion(), calificacion(), "Ing. José Israel Rodríguez"),
                    Materia("Programación Estructurada", calificacion(), calificacion(), calificacion(), "Dra. Gricelda Rodríguez")
                )
            ),
            Cuatrimestre(
                "3er Cuatrimestre",
                "En curso",
                "Tecnologías de la Información",
                "4A Matutino",
                "Dra. Gricelda Rodríguez Robledo",
                49,
                listOf(
                    Materia("Aplicaciones Web", calificacion(), calificacion(), calificacion(), "Dra. Gricelda Rodríguez"),
                    Materia("Desarrollo de Apps Móviles", calificacion(), calificacion(), calificacion(), "Ing. Nelson Padilla")
                )
            )
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {
            Text(
                text = "Historial Académico",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(Modifier.height(16.dp))
        }

        items(cuatrimestres) { cuatri ->
            CuatrimestreItem(cuatri)
            Spacer(Modifier.height(12.dp))
        }

        item {
            Spacer(Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                OutlinedButton(onClick = onLogoutClick) {
                    Text("Cerrar sesión")
                }
            }
        }
    }
}

// -------------------- COMPONENTES --------------------

@Composable
private fun CuatrimestreItem(cuatrimestre: Cuatrimestre) {

    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = { expanded = !expanded }
    ) {
        Column(Modifier.padding(16.dp)) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(cuatrimestre.nombre, style = MaterialTheme.typography.titleMedium)
                Icon(
                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = null
                )
            }

            Spacer(Modifier.height(8.dp))
            Text("Estado: ${cuatrimestre.estado}")
            Text("Carrera: ${cuatrimestre.carrera}")
            Text("Grupo: ${cuatrimestre.grupo}")
            Text("Tutor: ${cuatrimestre.tutor}")
            Text("Progreso: ${cuatrimestre.progreso}%")

            if (expanded) {
                Spacer(Modifier.height(12.dp))
                cuatrimestre.materias.forEach { MateriaItem(it) }
            }
        }
    }
}

@Composable
private fun MateriaItem(materia: Materia) {
    Column(Modifier.padding(vertical = 6.dp)) {
        Text(materia.nombre, style = MaterialTheme.typography.bodyLarge)
        Text("P1: ${materia.parcial1}  |  P2: ${materia.parcial2}  |  P3: ${materia.parcial3}")
        Text("Final: ${materia.final} (${letra(materia.final)})")
        Text("Maestro: ${materia.maestro}")
        Divider(Modifier.padding(top = 8.dp))
    }
}

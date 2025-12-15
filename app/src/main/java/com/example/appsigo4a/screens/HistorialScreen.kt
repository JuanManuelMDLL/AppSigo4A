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

fun calificacionAprobatoria(): Int = Random.nextInt(7, 11)

fun letra(calificacion: Int): String =
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

    val cuatrimestres = listOf(

        Cuatrimestre(
            "1er Cuatrimestre",
            "Finalizado",
            "Tecnologías de la Información",
            "1B Matutino",
            "Dra. Gricelda Rodríguez Robledo",
            100,
            listOf(
                Materia("Inglés I", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "Lic. María Verónica"),
                Materia("Desarrollo Humano y Valores", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "Lic. Laura Pérez Pazos"),
                Materia("Fundamentos Matemáticos", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "Lic. Rosa Isela González Raya"),
                Materia("Fundamentos de Redes", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "M.T.I Rosario Hernández Calderón"),
                Materia("Física", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "I.S.C Juan José Bermúdez Camille"),
                Materia("Fundamentos de Programación", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "I.T.I Julio César Correa Torres"),
                Materia("Comunicación y Habilidades Digitales", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "Dra. Olga Leticia Robles García")
            )
        ),

        Cuatrimestre(
            "2do Cuatrimestre",
            "Finalizado",
            "Tecnologías de la Información",
            "2A Matutino",
            "Dra. Gricelda Rodríguez Robledo",
            100,
            listOf(
                Materia("Inglés II", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "Lic. María Verónica Álvarez Ríos"),
                Materia("Habilidades Socioemocionales", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "Lic. José Luis Calvillo Banda"),
                Materia("Cálculo Diferencial", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "Ing. José Israel Rodríguez Flores"),
                Materia("Conmutación y Enrutamiento de Redes", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "M.T.I Rosario Hernández Calderón"),
                Materia("Probabilidad y Estadística", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "I.S.C Juan José Bermúdez Camille"),
                Materia("Programación Estructurada", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "Dra. Gricelda Rodríguez Robledo"),
                Materia("Sistemas Operativos", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "Dra. Olga Leticia Robles García")
            )
        ),

        Cuatrimestre(
            "3er Cuatrimestre",
            "Finalizado",
            "Tecnologías de la Información",
            "3A Matutino",
            "Dra. Gricelda Rodríguez Robledo",
            100,
            listOf(
                Materia("Inglés III", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "Dra. Leticia Rubicela Rodríguez Ruiz"),
                Materia("Desarrollo del Pensamiento y Toma de Decisiones", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "Dra. Olga Leticia Robles García"),
                Materia("Cálculo Integral", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "Ing. Dante García García"),
                Materia("Tópicos de Calidad para el Diseño", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "D.G María del Carmen Solorio Raya"),
                Materia("Bases de Datos", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "M.G.T.I Gustavo Abraham Vanegas Contreras"),
                Materia("Programación Orientada a Objetos", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "Dra. Gricelda Rodríguez Robledo"),
                Materia("Proyecto Integrador I", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "I.S.C Alma Lilia González Áspera")
            )
        ),

        Cuatrimestre(
            "4to Cuatrimestre",
            "En curso",
            "Tecnologías de la Información",
            "4A Matutino",
            "Dra. Gricelda Rodríguez Robledo",
            49,
            listOf(
                Materia("Inglés IV", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "Lic. Marco Antonio Suárez Villanueva"),
                Materia("Ética Profesional", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "Juan Ghaleb Sánchez López"),
                Materia("Cálculo de Varias Variables", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "Ing. José Israel Rodríguez Flores"),
                Materia("Aplicaciones Web", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "Dra. Gricelda Rodríguez Robledo"),
                Materia("Estructura de Datos", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "M.G.T.I Gustavo Abraham Vanegas Contreras"),
                Materia("Desarrollo de Aplicaciones Móviles", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "I.S.C Nelson Grozby Padilla Álvarez"),
                Materia("Análisis y Diseño de Software", calificacionAprobatoria(), calificacionAprobatoria(), calificacionAprobatoria(), "M.T.I Marcela Álvarez Vivanco")
            )
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {

        item {
            Text("Historial Académico", style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(16.dp))
        }

        items(cuatrimestres) { cuatri ->
            CuatrimestreItem(cuatri)
            Spacer(Modifier.height(12.dp))
        }

        item {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                OutlinedButton(onClick = onLogoutClick) {
                    Text("Cerrar sesión")
                }
            }
        }
    }
}

// -------------------- COMPONENTES --------------------

@Composable
fun CuatrimestreItem(cuatrimestre: Cuatrimestre) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = { expanded = !expanded }
    ) {
        Column(Modifier.padding(16.dp)) {

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(cuatrimestre.nombre, style = MaterialTheme.typography.titleMedium)
                Icon(if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore, null)
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
fun MateriaItem(materia: Materia) {
    Column(Modifier.padding(vertical = 6.dp)) {
        Text(materia.nombre, style = MaterialTheme.typography.bodyLarge)
        Text("Parcial 1: ${materia.parcial1}")
        Text("Parcial 2: ${materia.parcial2}")
        Text("Parcial 3: ${materia.parcial3}")
        Text("Final: ${materia.final} (${letra(materia.final)})")
        Text("Maestro: ${materia.maestro}")
        Divider(Modifier.padding(top = 8.dp))
    }
}

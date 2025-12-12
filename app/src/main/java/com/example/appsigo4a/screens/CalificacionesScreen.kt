package com.example.appsigo4a.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.example.appsigo4a.components.MateriaInfoRow
import androidx.compose.material3.HorizontalDivider

data class Materia(
    val nombre: String,
    val docente: String,
    val progreso: Int,
    val evaluacion: String,
    val desempeno: String,
    val unidades: List<Pair<String, String>>
)

@Composable
fun CalificacionesScreen(onBackClick: () -> Unit) {
    val materias = listOf(
        Materia("Programación Orientada a Objetos", "Ing. Mariana López", 95, "Ordinaria", "A (Autónomo)", listOf("Clases y Objetos" to "Autónomo", "Herencia" to "Estratégico")),
        Materia("Bases de Datos", "Mtro. Jorge Ramírez", 90, "Ordinaria", "B (Básico)", listOf("Modelo relacional" to "Básico", "Consultas SQL" to "Estratégico")),
        Materia("Desarrollo de Aplicaciones Móviles", "Mtra. Laura Sánchez", 88, "Ordinaria", "C (Intermedio)", listOf("Interfaces en Android" to "Intermedio", "Navegación" to "Autónomo"))
    )

    Column(modifier = Modifier.padding(20.dp)) {
        Text("Calificaciones - 4to Cuatrimestre", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(20.dp))

        materias.forEach { materia ->
            MateriaCard(materia)
            Spacer(Modifier.height(24.dp))
        }

        OutlinedButton(onClick = onBackClick, modifier = Modifier.align(Alignment.End)) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text("Regresar")
        }
    }
}

@Composable
fun MateriaCard(materia: Materia) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(materia.nombre, style = MaterialTheme.typography.titleMedium)
        Text("Docente: ${materia.docente}", style = MaterialTheme.typography.bodyMedium)

        Spacer(Modifier.height(10.dp))
        HorizontalDivider(thickness = 1.dp, color = Color.Black)

        MateriaInfoRow("Progreso", "${materia.progreso}%")
        MateriaInfoRow("Evaluación", materia.evaluacion)
        MateriaInfoRow("Desempeño", materia.desempeno)

        Spacer(Modifier.height(10.dp))
        Text("Unidades Temáticas", style = MaterialTheme.typography.bodyLarge)

        materia.unidades.forEach { (tema, nivel) ->
            MateriaInfoRow(tema, nivel)
        }
    }
}
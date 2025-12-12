package com.example.appsigo4a.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.appsigo4a.components.InfoRow
import androidx.compose.material3.HorizontalDivider

data class AcademicPeriod(
    val cuatrimestre: String,
    val fecha: String,
    val estado: String,
    val carrera: String,
    val grupo: String,
    val tutor: String,
    val progreso: Int,
    val desempeno: String
)

@Composable
fun HistorialScreen(
    onLogoutClick: () -> Unit,
    onVerCalificacionesClick: () -> Unit
) {
    val historial = listOf(
        AcademicPeriod("4to Cuatrimestre", "Sep - Dic 2025", "Activo", "Tecnologías de la Información", "4A Matutino", "Mtra. Laura Sánchez", 80, "Por capturar"),
        AcademicPeriod("3er Cuatrimestre", "May - Ago 2025", "Finalizado", "Tecnologías de la Información", "3B Matutino", "Ing. Carlos Méndez", 100, "A (Autónomo)"),
        AcademicPeriod("2do Cuatrimestre", "Ene - Abr 2025", "Finalizado", "Tecnologías de la Información", "2B Matutino", "Dra. Olga Leticia Robles García", 100, "A (Autónomo)"),
        AcademicPeriod("1er Cuatrimestre", "Sep - Dic 2024", "Finalizado", "Tecnologías de la Información", "1B Matutino", "M.G.T.I. Gerardo Chávez Hernández", 100, "B (Básico)")
    )

    Column(modifier = Modifier.padding(20.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 16.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.School, contentDescription = null, Modifier.size(30.dp))
                Spacer(Modifier.width(8.dp))
                Icon(Icons.Filled.Menu, contentDescription = null, Modifier.size(30.dp))
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.AccountCircle, contentDescription = null, Modifier.size(30.dp))
                Spacer(Modifier.width(8.dp))
                Icon(Icons.Filled.MoreVert, contentDescription = null, Modifier.size(30.dp))
            }
        }

        Spacer(Modifier.height(20.dp))

        Text("Historial Académico", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)

        Spacer(Modifier.height(20.dp))

        historial.forEach { periodo ->
            AcademicCard(periodo, onVerCalificacionesClick)
            Spacer(Modifier.height(24.dp))
        }

        OutlinedButton(onClick = onLogoutClick, modifier = Modifier.align(Alignment.End)) {
            Icon(Icons.Filled.Logout, contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text("Cerrar sesión")
        }
    }
}

@Composable
fun AcademicCard(periodo: AcademicPeriod, onVerCalificacionesClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(periodo.cuatrimestre, style = MaterialTheme.typography.titleMedium)
                Text(periodo.fecha, style = MaterialTheme.typography.bodyMedium)
            }
            if (periodo.cuatrimestre == "4to Cuatrimestre") {
                IconButton(onClick = onVerCalificacionesClick) {
                    Icon(Icons.Filled.List, contentDescription = "Ver calificaciones")
                }
            }
        }

        Spacer(Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Filled.CheckCircle, contentDescription = null, Modifier.size(24.dp))
            Spacer(Modifier.width(8.dp))
            Text(periodo.estado, style = MaterialTheme.typography.bodyMedium)
        }

        Spacer(Modifier.height(10.dp))
        HorizontalDivider(thickness = 1.dp, color = Color.Black)

        InfoRow("Carrera", periodo.carrera)
        InfoRow("Grupo", periodo.grupo)
        InfoRow("Tutor", periodo.tutor)
        InfoRow("Progreso", "${periodo.progreso}%")
        InfoRow("Desempeño", periodo.desempeno)
    }
}
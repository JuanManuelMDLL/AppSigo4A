package com.example.appsigo4a.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.Alignment
import androidx.compose.foundation.border

@Composable
fun HistorialScreen() {
    val historial = AcademicHistory(
        cuatrimestre = "1er Cuatrimestre",
        carrera = "Tecnologías de la Información",
        grupo = "1A Matutino",
        tutor = "Dra. Gricelda Rodríguez Robledo",
        progreso = 49
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        // Rectángulo superior con iconos
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 16.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(10.dp)) // Borde del rectángulo
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.School, contentDescription = "Sigo Icon", modifier = Modifier.size(30.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Icon(Icons.Filled.Menu, contentDescription = "Menu Icon", modifier = Modifier.size(30.dp))
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.AccountCircle, contentDescription = "Perfil Icon", modifier = Modifier.size(30.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Icon(Icons.Filled.MoreVert, contentDescription = "More Options", modifier = Modifier.size(30.dp))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Título centrado
        Text("Historial Académico", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.fillMaxWidth(), textAlign = androidx.compose.ui.text.style.TextAlign.Center)

        // Línea delgada
        Spacer(modifier = Modifier.height(10.dp))
        Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(10.dp))

        // Cuatrimestre y fecha (alineados a la izquierda)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Column(horizontalAlignment = Alignment.Start) {
                Text("1er Cuatrimestre", style = MaterialTheme.typography.bodyLarge)
                Text("Sep - Dic 2024", style = MaterialTheme.typography.bodyMedium)
            }
        }

        // Línea delgada (y eliminación del icono "+")
        Spacer(modifier = Modifier.height(10.dp))
        Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.fillMaxWidth())

        // Palomita y texto "Actividad"
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(Icons.Filled.CheckCircle, contentDescription = "Actividad", modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Activo", style = MaterialTheme.typography.bodyMedium)
        }

        // Línea delgada
        Spacer(modifier = Modifier.height(10.dp))
        Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.fillMaxWidth(0.9f))

        // Información académica (en una sola línea: título a la izquierda, contenido a la derecha)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Carrera", style = MaterialTheme.typography.bodyLarge)
            Text(text = historial.carrera, style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Grupo", style = MaterialTheme.typography.bodyLarge)
            Text(text = historial.grupo, style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Tutor", style = MaterialTheme.typography.bodyLarge)
            Text(text = historial.tutor, style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Progreso", style = MaterialTheme.typography.bodyLarge)
            Text(text = "${historial.progreso}%", style = MaterialTheme.typography.bodyMedium)
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Desempeño sin línea delgada
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Desempeño", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Por capturar", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

data class AcademicHistory(
    val cuatrimestre: String,
    val carrera: String,
    val grupo: String,
    val tutor: String,
    val progreso: Int
)

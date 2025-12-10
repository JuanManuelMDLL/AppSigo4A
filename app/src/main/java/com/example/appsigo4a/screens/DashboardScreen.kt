package com.example.appsigo4a.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Historial Académico", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { /* Acción menú */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menú")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Acción perfil cabecera */ }) {
                        Icon(Icons.Default.AccountCircle, contentDescription = "Perfil")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            // Cabecera del periodo
            Text(text = "1er Cuatrimestre", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = "Sep - Dic 2024", color = Color.Gray, fontSize = 14.sp)

            HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

            // Tarjeta 1: Mi Perfil (Navega al hacer clic)
            MenuItemCard(
                title = "Mi perfil",
                subtitle = "Valida tu información personal y mantenla siempre actualizada.",
                icon = Icons.Default.Person,
                onClick = { navController.navigate("profile_screen") } // <--- NAVEGACIÓN AQUÍ
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Tarjeta 2: Historial
            MenuItemCard(
                title = "Mi Historial académico",
                subtitle = "Consulta tu historial y estate al pendiente de tu estatus académico",
                icon = Icons.Default.DateRange,
                onClick = { /* Navegar a historial si existiera */ }
            )
        }
    }
}

@Composable
fun MenuItemCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick), // Hace click en toda la tarjeta
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White) // Fondo blanco para que resalte
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = subtitle, fontSize = 14.sp, lineHeight = 20.sp)
        }
    }
}
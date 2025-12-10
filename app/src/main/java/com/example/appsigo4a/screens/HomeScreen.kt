package com.example.appsigo4a.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.foundation.border
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.School

@Composable
fun HomeScreen(
    onPerfilClick: () -> Unit,
    onHistorialClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Rectángulo superior con íconos a la izquierda y foto de perfil a la derecha
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

        Spacer(modifier = Modifier.height(20.dp))

        // Título de bienvenida
        Text(
            text = "Bienvenido",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(20.dp))

        // ----------- TARJETA MI PERFIL ----------- 
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onPerfilClick()
                },
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Filled.Person, contentDescription = "Perfil")
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = "Mi perfil",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Valida tu información personal y mantenla actualizada.",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ----------- TARJETA HISTORIAL ----------- 
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onHistorialClick()
                },
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Filled.Folder, contentDescription = "Historial")
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = "Mi historial académico",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Consulta tu historial y estate al pendiente de tu estatus académico.",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

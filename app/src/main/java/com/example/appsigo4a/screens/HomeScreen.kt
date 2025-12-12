package com.example.appsigo4a.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.School
import androidx.compose.ui.platform.LocalContext
import com.example.appsigo4a.data.local.TokenManager

@Composable
fun HomeScreen(
    onPerfilClick: () -> Unit,
    onHistorialClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    val context = LocalContext.current
    val tokenManager = remember { TokenManager(context) }

    val fullName = tokenManager.getFullName() ?: "Usuario"
    val username = tokenManager.getUsername() ?: ""


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

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
                Icon(Icons.Filled.School, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Icon(Icons.Filled.Menu, contentDescription = null)
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(username ?: "Cargando...", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(Icons.Filled.AccountCircle, contentDescription = null)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))


        // ⭐ Mostrar nombre del usuario debajo del rectángulo
        Text(
            text = "Bienvenido, $fullName",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Botón cerrar sesión (NO MODIFICADO)
        OutlinedButton(
            onClick = { onLogoutClick() },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Cerrar sesión")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // TARJETA MI PERFIL (NO CAMBIADA)
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
                    Text("Mi perfil", style = MaterialTheme.typography.titleMedium)
                    Text("Valida tu información personal y mantenla actualizada.",
                        style = MaterialTheme.typography.bodySmall)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // TARJETA HISTORIAL (NO CAMBIADA)
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
                    Text("Mi historial académico", style = MaterialTheme.typography.titleMedium)
                    Text("Consulta tu historial y estate al pendiente de tu estatus académico.",
                        style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}


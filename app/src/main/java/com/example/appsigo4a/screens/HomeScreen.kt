package com.example.appsigo4a.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.border
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Logout
import com.example.appsigo4a.data.local.TokenManager

@Composable
fun HomeScreen(
    onPerfilClick: () -> Unit,
    onHistorialClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    val context = LocalContext.current
    val tokenManager = remember { TokenManager(context) }

    // ✅ Usamos el nuevo getter
    val fullName = tokenManager.getPersonFullName() ?: "Usuario"
    val username = tokenManager.getUsername() ?: ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Barra superior
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 16.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Bienvenido",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = fullName,
                    style = MaterialTheme.typography.bodyLarge
                )
                if (username.isNotEmpty()) {
                    Text(
                        text = "@$username",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
            }

            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Opción: Perfil
        HomeOptionItem(
            title = "Mi perfil",
            icon = Icons.Filled.AccountCircle,
            onClick = onPerfilClick
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Opción: Historial
        HomeOptionItem(
            title = "Historial",
            icon = Icons.Filled.History,
            onClick = onHistorialClick
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botón cerrar sesión
        OutlinedButton(
            onClick = onLogoutClick,
            modifier = Modifier.align(Alignment.End)
        ) {
            Icon(
                imageVector = Icons.Filled.Logout,
                contentDescription = null
            )
            Spacer(Modifier.width(8.dp))
            Text("Cerrar sesión")
        }
    }
}

@Composable
fun HomeOptionItem(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(icon, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text(title, style = MaterialTheme.typography.bodyLarge)
            }
            Icon(Icons.Filled.ArrowForward, contentDescription = null)
        }
    }
}
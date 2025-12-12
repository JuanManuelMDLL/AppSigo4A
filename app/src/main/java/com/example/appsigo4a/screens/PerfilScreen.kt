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
import androidx.compose.foundation.border
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import com.example.appsigo4a.data.local.TokenManager

@Composable
fun PerfilScreen(
    onLogoutClick: () -> Unit
) {
    val context = LocalContext.current
    val tokenManager = TokenManager(context)

    val fullName = tokenManager.getFullName() ?: "Usuario"
    val username = tokenManager.getUsername() ?: ""
    val email = tokenManager.getEmail() ?: ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        // Rectángulo superior
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
                Icon(Icons.Filled.School, null, Modifier.size(30.dp))
                Spacer(Modifier.width(8.dp))
                Icon(Icons.Filled.Menu, null, Modifier.size(30.dp))
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.AccountCircle, null, Modifier.size(30.dp))
                Spacer(Modifier.width(8.dp))
                Icon(Icons.Filled.MoreVert, null, Modifier.size(30.dp))
            }
        }

        Spacer(Modifier.height(20.dp))

        // Foto + nombre
        Row {
            Icon(Icons.Filled.AccountCircle, null, Modifier.size(40.dp))
            Spacer(Modifier.width(10.dp))
            Text(fullName, style = MaterialTheme.typography.bodyLarge)
        }

        Spacer(Modifier.height(10.dp))
        Divider(color = Color.Black)

        Spacer(Modifier.height(10.dp))
        Row {
            Icon(Icons.Filled.CheckCircle, null)
            Spacer(Modifier.width(8.dp))
            Text("Perfil activo")
        }

        Spacer(Modifier.height(20.dp))

        UserProfileCard("Perfil", "Alumno")
        Spacer(Modifier.height(10.dp))
        UserProfileCard("Usuario", username)
        Spacer(Modifier.height(10.dp))
        UserProfileCard("Correo", email)

        Spacer(Modifier.height(30.dp))

        OutlinedButton(
            onClick = onLogoutClick,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Cerrar sesión")
        }
    }
}

@Composable
fun UserProfileCard(title: String, content: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(title, style = MaterialTheme.typography.bodyLarge)
        Text(content, style = MaterialTheme.typography.bodyMedium)
    }
}

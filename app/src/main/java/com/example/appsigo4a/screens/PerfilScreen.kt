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
    val profile = tokenManager.getProfileName() ?: "Alumno"
    val module = tokenManager.getAccessModule() ?: ""
    val active = tokenManager.isActive()
    val registerDate = tokenManager.getRegisterDate() ?: ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        // 🔹 Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Icon(Icons.Filled.School, null)
                Spacer(Modifier.width(8.dp))
                Icon(Icons.Filled.Menu, null)
            }
            Row {
                Icon(Icons.Filled.AccountCircle, null)
                Spacer(Modifier.width(8.dp))
                Icon(Icons.Filled.MoreVert, null)
            }
        }

        Spacer(Modifier.height(20.dp))

        // 🔹 Foto + Nombre
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Filled.AccountCircle, null, Modifier.size(40.dp))
            Spacer(Modifier.width(10.dp))
            Text(fullName, style = MaterialTheme.typography.bodyLarge)
        }

        Spacer(Modifier.height(10.dp))
        Divider()

        // 🔹 Estado
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                if (active) Icons.Filled.CheckCircle else Icons.Filled.Cancel,
                null
            )
            Spacer(Modifier.width(8.dp))
            Text(if (active) "Perfil activo" else "Perfil inactivo")
        }

        Spacer(Modifier.height(20.dp))

        // 🔹 Datos del perfil (formato bonito)
        UserProfileCard("Perfil", profile)
        UserProfileCard("Usuario", username)
        UserProfileCard("Correo", email)
        UserProfileCard("Módulo", module)
        UserProfileCard("Fecha de registro", registerDate)

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

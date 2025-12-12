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

    val fullName = tokenManager.getPersonFullName() ?: "Usuario"
    val username = tokenManager.getUsername() ?: ""
    val email = tokenManager.getEmail() ?: ""
    val profileName = tokenManager.getProfileName() ?: ""
    val register = tokenManager.getRegister() ?: ""
    val active = tokenManager.isActive()
    val terms = tokenManager.hasAcceptedTerms()
    val roles = tokenManager.getRoles().joinToString(", ")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        // Encabezado superior
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
                Icon(Icons.Filled.AccountCircle, contentDescription = null, Modifier.size(40.dp))
                Spacer(Modifier.width(8.dp))
                Column {
                    Text(fullName, style = MaterialTheme.typography.bodyLarge)
                    Text(username, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                }
            }

            Icon(Icons.Filled.MoreVert, contentDescription = null, Modifier.size(30.dp))
        }

        Spacer(Modifier.height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Filled.CheckCircle,
                contentDescription = null,
                tint = Color.Gray
            )
            Spacer(Modifier.width(8.dp))
            Text("Perfil activo")
        }

        Spacer(Modifier.height(20.dp))

        // Información institucional
        UserProfileCard("Perfil", profileName)
        UserProfileCard("Correo institucional", email)
        UserProfileCard("Roles", roles)
        UserProfileCard("Fecha de registro", register)
        UserProfileCard("Términos aceptados", if (terms) "Sí" else "No")

        Spacer(Modifier.height(30.dp))

        OutlinedButton(
            onClick = onLogoutClick,
            modifier = Modifier.align(Alignment.End)
        ) {
            Icon(Icons.Filled.Logout, contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text("Cerrar sesión")
        }
    }
}

@Composable
fun UserProfileCard(title: String, content: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(title, style = MaterialTheme.typography.bodyLarge)
        Text(content, style = MaterialTheme.typography.bodyMedium)
    }
}

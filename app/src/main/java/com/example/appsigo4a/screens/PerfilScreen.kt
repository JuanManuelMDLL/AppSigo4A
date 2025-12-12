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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.border
import androidx.compose.ui.Alignment

@Composable
fun PerfilScreen(onLogout: () -> Unit) {

    val user = UserProfile(
        username = "UTM201020TI",
        email = "utm151015TI@utm-morelia.edu.mx",
        password = "2006817"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
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

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(Icons.Filled.AccountCircle, contentDescription = "Foto de perfil", modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Usuario de prueba", style = MaterialTheme.typography.bodyLarge)
        }

        Spacer(modifier = Modifier.height(10.dp))
        Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.fillMaxWidth(0.9f))

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(Icons.Filled.CheckCircle, contentDescription = "Perfil activo", modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Perfil activo", style = MaterialTheme.typography.bodyMedium)
        }

        Spacer(modifier = Modifier.height(10.dp))
        Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.fillMaxWidth(0.9f))

        Spacer(modifier = Modifier.height(20.dp))

        UserProfileCard(title = "Perfil", content = "Alumno")
        Spacer(modifier = Modifier.height(10.dp))
        UserProfileCard(title = "Usuario", content = user.username)
        Spacer(modifier = Modifier.height(10.dp))
        UserProfileCard(title = "Contraseña", content = "CAMBIAR")

        Spacer(modifier = Modifier.height(20.dp))
        Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(10.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Filled.Bookmark, contentDescription = "Bookmark Icon", modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Información Institucional", style = MaterialTheme.typography.bodyLarge)
        }

        Spacer(modifier = Modifier.height(10.dp))
        Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.fillMaxWidth(0.9f))

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Este es tu correo electronico institucional, entra a Gmail de Google, agrega esta cuenta y personaliza tu contraseña.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        UserProfileCard(title = "Correo", content = user.email)
        Spacer(modifier = Modifier.height(10.dp))
        UserProfileCardWithSpacing(title = "Contraseña", content = "2006817 - Si aún no la has personalizado", spacing = 24)

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(6.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Importante", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "El correo electrónico estará activo una semana después del inicio del cuatrimestre.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Este es tu usuario y contraseña, para entrar a e-libro", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(10.dp))
        UserProfileCard(title = "Usuario", content = user.email)
        Spacer(modifier = Modifier.height(10.dp))
        UserProfileCardWithSpacing(
            title = "Contraseña",
            content = "pass.2024 - Si aún no la has personalizado",
            spacing = 24
        )

        // ------------------ BOTÓN DE CERRAR SESIÓN ------------------
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { onLogout() },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD32F2F),
                contentColor = Color.White
            )
        ) {
            Text("Cerrar sesión")
        }
        // -------------------------------------------------------------
    }
}

@Composable
fun UserProfileCard(title: String, content: String) {
    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title, style = MaterialTheme.typography.bodyLarge)
            Text(text = content, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun UserProfileCardWithSpacing(title: String, content: String, spacing: Int) {
    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.width(spacing.dp))
            Text(text = content, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

data class UserProfile(val username: String, val email: String, val password: String)
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

data class UserProfile(val username: String, val email: String, val password: String)

@Composable
fun PerfilScreen(
    onLogoutClick: () -> Unit // Nueva función para manejar el cierre de sesión
) {
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

        // Foto de perfil y usuario
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(Icons.Filled.AccountCircle, contentDescription = "Foto de perfil", modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Usuario de prueba", style = MaterialTheme.typography.bodyLarge)
        }

        // Línea delgada
        Spacer(modifier = Modifier.height(10.dp))
        Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.fillMaxWidth(0.9f))

        Spacer(modifier = Modifier.height(10.dp))

        // Sección de perfil activo con icono de check
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start // Alineamos a la izquierda
        ) {
            Icon(Icons.Filled.CheckCircle, contentDescription = "Perfil activo", modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(8.dp)) // Aumentamos el espacio entre el ícono y el texto
            Text(text = "Perfil activo", style = MaterialTheme.typography.bodyMedium)
        }

        // Otra línea delgada
        Spacer(modifier = Modifier.height(10.dp))
        Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.fillMaxWidth(0.9f))

        Spacer(modifier = Modifier.height(20.dp))

        // Datos de perfil
        UserProfileCard(title = "Perfil", content = "Alumno")
        Spacer(modifier = Modifier.height(10.dp))
        UserProfileCard(title = "Usuario", content = user.username)
        Spacer(modifier = Modifier.height(10.dp))
        UserProfileCard(title = "Contraseña", content = "CAMBIAR")

        Spacer(modifier = Modifier.height(20.dp))

        // Otra línea delgada
        Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(10.dp))

        // Información Institucional
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Filled.Bookmark, contentDescription = "Bookmark Icon", modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Información Institucional", style = MaterialTheme.typography.bodyLarge)
        }

        // Línea delgada
        Spacer(modifier = Modifier.height(10.dp))
        Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.fillMaxWidth(0.9f))

        Spacer(modifier = Modifier.height(10.dp))

        // Texto explicativo
        Text(
            text = "Este es tu correo electronico institucional, entra a Gmail de Google, agrega esta cuenta y personaliza tu contraseña.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Datos de correo e información adicional
        UserProfileCard(title = "Correo", content = user.email)
        Spacer(modifier = Modifier.height(10.dp))

        // Se agregó más espacio entre las contraseñas
        UserProfileCardWithSpacing(title = "Contraseña", content = "2006817 - Si aún no la has personalizado", spacing = 24)

        Spacer(modifier = Modifier.height(20.dp))

        // Rectángulo importante
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(6.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray) // Se corrigió 'backgroundColor' a 'containerColor'
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Importante", style = MaterialTheme.typography.bodyLarge) // Se corrigió 'h6' a 'bodyLarge'
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "El correo electrónico estará activo una semana después del inicio del cuatrimestre.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Usuario y contraseña para e-libro
        Text(text = "Este es tu usuario y contraseña, para entrar a e-libro", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(10.dp))
        UserProfileCard(title = "Usuario", content = user.email)
        Spacer(modifier = Modifier.height(10.dp))

        // Contraseña para e-libro con mayor separación
        UserProfileCardWithSpacing(title = "Contraseña", content = "pass.2024 - Si aún no la has personalizado", spacing = 24)

        Spacer(modifier = Modifier.height(20.dp))

        // Botón para cerrar sesión
        OutlinedButton(
            onClick = { onLogoutClick() },
            modifier = Modifier.align(Alignment.End).padding(top = 20.dp)
        ) {
            Text("Cerrar sesión")
        }
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
            Spacer(modifier = Modifier.width(spacing.dp)) // Ajustamos el espaciado entre título y contenido
            Text(text = content, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

package com.example.appsigo4a.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appsigo4a.data.Alumno
import com.example.appsigo4a.data.Repositorio
import kotlinx.coroutines.launch

@Composable
fun PerfilScreen(repositorio: Repositorio) {

    var alumno by remember { mutableStateOf<Alumno?>(null) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            alumno = repositorio.obtenerAlumno()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        // ========= ENCABEZADO =========
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(Icons.Default.Person, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Usuario de prueba 1", style = MaterialTheme.typography.titleLarge)
        }

        Divider(modifier = Modifier.padding(vertical = 12.dp))

        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Icon(Icons.Default.Check, contentDescription = null)
            Spacer(modifier = Modifier.width(6.dp))
            Text("Perfil activo")
        }

        Spacer(modifier = Modifier.height(12.dp))

        alumno?.let {

            // ========= DATOS PRINCIPALES =========
            Text("Perfil:  Alumno")
            Spacer(modifier = Modifier.height(6.dp))
            Text("Usuario:  ${it.matricula}")
            Spacer(modifier = Modifier.height(6.dp))
            Text("Contraseña:  CAMBIAR")

            Divider(modifier = Modifier.padding(vertical = 16.dp))

            // ========= INFORMACIÓN INSTITUCIONAL =========
            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Icon(Icons.Default.Info, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Información institucional", style = MaterialTheme.typography.titleMedium)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Este es tu correo electrónico institucional, entra a Gmail de Google, " +
                        "agrega esta cuenta y personaliza tu contraseña"
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text("Correo:  ${it.correo}")
            Spacer(modifier = Modifier.height(6.dp))
            Text("Contraseña:  20060817- Si aun no la has personalizado")
            Spacer(modifier = Modifier.height(6.dp))
            Text("Agrégala a:  Gmail de Google")

            // ========= TARJETA DE AVISO =========
            Spacer(modifier = Modifier.height(20.dp))

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Importante", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "El correo electrónico estará activo una semana después del inicio del cuatrimestre"
                    )
                }
            }

            // ========= ACCESO A E-LIBRO =========
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "Este es tu usuario y contraseña, para entrar a e-libro",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text("Usuario:  ${it.correo}")
            Spacer(modifier = Modifier.height(6.dp))
            Text("Contraseña:  pass.2024- Si aun no la has personalizado")
        }
    }
}

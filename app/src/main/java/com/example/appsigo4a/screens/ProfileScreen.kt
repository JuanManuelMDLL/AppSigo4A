package com.example.appsigo4a.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { }, // Sin título centrado para imitar la imagen
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) { // <--- VOLVER ATRÁS
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Atrás")
                    }
                },
                actions = {
                    // Nombre e icono a la derecha como en la imagen
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        Text("Usuario de prueba 1", fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.Default.AccountCircle, contentDescription = null)
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()) // Habilitar scroll
                .padding(16.dp)
        ) {

            // Sección 1
            SectionHeader("Mi perfil")
            ProfileRowInfo(label = "Perfil", value = "Alumno")
            ProfileRowInfo(label = "Usuario", value = "UTM201020TI")
            ProfileRowAction(label = "Contraseña", value = "CAMBIAR", isButton = true)

            Spacer(modifier = Modifier.height(24.dp))

            // Sección 2
            SectionHeader("Alumno")
            // Aquí irían datos del alumno si los hubiera en el futuro

            Spacer(modifier = Modifier.height(24.dp))

            // Sección 3: Info Institucional
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.AccountCircle, contentDescription = null, tint = Color.Black) // Icono bandera simulado
                Spacer(modifier = Modifier.width(8.dp))
                Text("Información institucional", fontWeight = FontWeight.Bold)
            }
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

            Text(
                "Este es tu correo electrónico institucional, entra a Gmail de Google, agrega esta cuenta y personaliza tu contraseña",
                fontSize = 12.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(16.dp))

            ProfileRowInfo(label = "Correo", value = "utm151015TI@ut-\nmorelia.edu.mx")
            ProfileRowInfo(label = "Contraseña", value = "20060817 - Si aun no la has personalizado")

            Spacer(modifier = Modifier.height(8.dp))
            ProfileRowInfo(label = "Agrégala a", value = "Gmail de Google")

            Spacer(modifier = Modifier.height(24.dp))

            // Caja de Importante
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                    .padding(16.dp)
            ) {
                Column {
                    Text("Importante", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("El correo electrónico estará activo una semana después del inicio del cuatrimestre.")
                }
            }
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.AccountCircle, contentDescription = null) // Check icon simulado
        Spacer(modifier = Modifier.width(8.dp))
        Text(title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
}

@Composable
fun ProfileRowInfo(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.3f))
        Text(text = value, modifier = Modifier.weight(0.7f))
    }
}

@Composable
fun ProfileRowAction(label: String, value: String, isButton: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.3f))

        if (isButton) {
            Button(
                onClick = {},
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
                modifier = Modifier.height(35.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE0E0E0), contentColor = Color.Black)
            ) {
                Text("CAMBIAR")
            }
        }
    }
}
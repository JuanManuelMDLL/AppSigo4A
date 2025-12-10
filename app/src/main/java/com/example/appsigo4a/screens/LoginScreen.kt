package com.example.appsigo4a.screens

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(activity: Activity) {

    val context = LocalContext.current

    var usuario by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "SIGO UTM",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Usuario") },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = null)
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = null)
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {

                // USUARIO DE PRUEBA
                if (usuario == "utm2025" && password == "1234") {

                    Toast.makeText(
                        context,
                        "Login exitoso",
                        Toast.LENGTH_SHORT
                    ).show()

                    val intent = Intent(context, HomeActivity::class.java)
                    context.startActivity(intent)
                    activity.finish()

                } else {
                    Toast.makeText(
                        context,
                        "Usuario o contraseña incorrectos",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Iniciar Sesión")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = {
            Toast.makeText(
                context,
                "Recuperación no implementada",
                Toast.LENGTH_SHORT
            ).show()
        }) {
            Text("¿Olvidaste tu contraseña?")
        }
    }
}


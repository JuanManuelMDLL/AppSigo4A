package com.example.appsigo4a.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appsigo4a.R
import com.example.appsigo4a.data.local.TokenManager
import com.example.appsigo4a.data.remote.AuthRepository
import com.example.appsigo4a.di.LoginViewModelFactory
import com.example.appsigo4a.ui.login.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {

    val context = LocalContext.current
    val tokenManager = remember { TokenManager(context) }

    // ViewModel
    val viewModel: LoginViewModel = viewModel(
        factory = LoginViewModelFactory(AuthRepository(tokenManager))
    )


    val loginState by viewModel.loginState.collectAsState()

    var usuario by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()

    LaunchedEffect(loginState) {
        loginState?.let { result ->
            loading = false

            result.onSuccess { user ->
                tokenManager.saveToken(user.bearer)
                tokenManager.saveUser(user)
                onLoginSuccess()
            }


            result.onFailure {
                error = "Credenciales incorrectas o servidor no disponible"
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(50.dp))

        // Logos
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logosigo),
                contentDescription = "LogoSIGO",
                modifier = Modifier.size(90.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.logoutm),
                contentDescription = "LogoUTM",
                modifier = Modifier.size(90.dp)
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            placeholder = { Text("Usuario") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Contraseña") },
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        if (error.isNotEmpty()) {
            Text(text = error, color = MaterialTheme.colorScheme.error)
            Spacer(modifier = Modifier.height(12.dp))
        }

        Button(
            onClick = {
                loading = true
                error = ""
                viewModel.login(usuario, password)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {

            if (loading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(22.dp)
                )
            } else {
                Text("INICIAR SESIÓN")
            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { }) {
            Text("¿Olvidaste tu contraseña?")
        }
    }
}

package com.example.appsigo4a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.appsigo4a.screens.LoginScreen
import com.example.appsigo4a.ui.theme.AppSigo4ATheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppSigo4ATheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    LoginScreen(this)
                }
            }
        }
    }
}

package com.example.appsigo4a.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.appsigo4a.ui.theme.AppSigo4ATheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppSigo4ATheme {

                HomeScreen(
                    onPerfilClick = {
                        val intent = Intent(this, PerfilActivity::class.java)
                        startActivity(intent)
                    },
                    onHistorialClick = {
                        val intent = Intent(this, HistorialActivity::class.java)
                        startActivity(intent)
                    }
                )

            }
        }
    }
}

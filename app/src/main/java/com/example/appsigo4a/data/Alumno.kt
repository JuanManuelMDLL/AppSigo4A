package com.example.appsigo4a.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alumno")
data class Alumno(
    @PrimaryKey val id: Int,
    val nombre: String,
    val apellido: String,
    val matricula: String,
    val carrera: String,
    val correo: String
)


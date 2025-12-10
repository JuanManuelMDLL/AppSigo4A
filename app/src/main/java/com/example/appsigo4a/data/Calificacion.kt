package com.example.appsigo4a.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "calificaciones")
data class Calificacion(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val materia: String,
    val promedio: Int,
    val cuatrimestre: String,
    val estado: String
)


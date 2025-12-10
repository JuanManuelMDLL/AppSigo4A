package com.example.appsigo4a.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Alumno::class, Calificacion::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun alumnoDao(): AlumnoDao
    abstract fun calificacionDao(): CalificacionDao
}



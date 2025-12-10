package com.example.appsigo4a.data

import android.content.Context
import androidx.room.Room

class Repositorio(context: Context) {

    private val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "sigo_db"
    ).build()

    private val alumnoDao = db.alumnoDao()
    private val calificacionDao = db.calificacionDao()

    suspend fun guardarAlumno(alumno: Alumno) {
        alumnoDao.insertarAlumno(alumno)
    }

    suspend fun guardarCalificaciones(lista: List<Calificacion>) {
        calificacionDao.insertarCalificaciones(lista)
    }

    suspend fun obtenerAlumno(): Alumno {
        return alumnoDao.obtenerAlumno()
    }

    suspend fun obtenerCalificaciones(): List<Calificacion> {
        return calificacionDao.obtenerCalificaciones()
    }
    suspend fun obtenerCalificacionesLocal(): List<Calificacion> {
        return calificacionDao.obtenerCalificaciones()
    }



}

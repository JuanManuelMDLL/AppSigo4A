package com.example.appsigo4a.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AlumnoDao {

    @Insert
    suspend fun insertarAlumno(alumno: Alumno)

    @Query("SELECT * FROM alumno LIMIT 1")
    suspend fun obtenerAlumno(): Alumno


}



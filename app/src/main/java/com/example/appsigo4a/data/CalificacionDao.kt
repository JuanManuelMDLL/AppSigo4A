package com.example.appsigo4a.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CalificacionDao {

    @Insert
    suspend fun insertarCalificaciones(lista: List<Calificacion>)

    @Query("SELECT * FROM calificaciones")
    suspend fun obtenerCalificaciones(): List<Calificacion>



}



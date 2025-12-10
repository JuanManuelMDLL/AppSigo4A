package com.example.appsigo4a.data

import retrofit2.http.GET

interface ApiService {

    @GET("alumno")
    suspend fun obtenerAlumno(): Alumno

    @GET("calificaciones")
    suspend fun obtenerCalificaciones(): List<Calificacion>
}

package com.example.appsigo4a.data.remote

import com.example.appsigo4a.data.model.LoginRequest
import com.example.appsigo4a.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("ws/rest/auth")
    suspend fun loginUser(
        @Body request: LoginRequest
    ): Response<UserResponse>

}

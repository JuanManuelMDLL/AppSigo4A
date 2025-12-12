package com.example.appsigo4a.data.remote

import com.example.appsigo4a.data.local.TokenManager
import com.example.appsigo4a.data.model.LoginRequest
import com.example.appsigo4a.data.model.UserResponse

class AuthRepository(
    private val tokenManager: TokenManager? = null
) {

    private val api = RetrofitClient.apiService

    suspend fun login(username: String, password: String): Result<UserResponse> {
        return try {
            val request = LoginRequest(
                username = username,
                password = password
            )

            val response = api.loginUser(request)

            if (response.isSuccessful && response.body() != null) {
                val user = response.body()!!

                // Guardamos token si existe TokenManager
                tokenManager?.saveToken(user.bearer)

                Result.success(user)
            } else {
                Result.failure(Exception("Credenciales inválidas"))
            }

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

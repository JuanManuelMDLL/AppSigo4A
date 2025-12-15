package com.example.appsigo4a.data.remote

import com.example.appsigo4a.data.local.TokenManager
import com.example.appsigo4a.data.model.LoginRequest
import com.example.appsigo4a.data.model.UserResponse
import retrofit2.Response

class AuthRepository(
    private val tokenManager: TokenManager
) {

    private val api = RetrofitClient.apiService

    suspend fun login(username: String, password: String): Result<UserResponse> {
        return try {
            val request = LoginRequest(username, password)
            val response = api.loginUser(request)

            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Credenciales inválidas"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}


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
            val request = LoginRequest(
                username = username,
                password = password
            )

            val response: Response<UserResponse> = api.loginUser(request)

            if (response.isSuccessful && response.body() != null) {
                val user = response.body()!!

                // ✅ AQUÍ se guardan TODOS los datos
                tokenManager.saveToken(user.bearer)
                tokenManager.saveUserData(
                    fullName = user.personFullName,
                    username = user.username,
                    email = user.email,
                    profile = user.profileName

                )
                tokenManager.saveExtraUserData(
                    module = user.accessModule,
                    registerDate = user.register
                )

                Result.success(user)
            } else {
                Result.failure(Exception("Credenciales inválidas"))
            }

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}


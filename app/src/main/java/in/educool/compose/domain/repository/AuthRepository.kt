package `in`.educool.compose.domain.repository

import `in`.educool.compose.data.dto.auth.*

interface AuthRepository {

    suspend fun login(body: LoginBodyDTO): LoginDTO

    suspend fun signup(body: LoginBodyDTO): SignUpDTO

    suspend fun verifyOtp(body: VerifyOtpBodyDTO): MessageDTO

    suspend fun resetPassword(email: String, new_password: String): MessageDTO

    suspend fun sendOtp(email: String): MessageDTO

    suspend fun generateTokens(email: String, password: String): TokenDTO

    suspend fun generateAccessToken(refresh: String): TokenDTO
}

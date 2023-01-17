package `in`.educool.compose.data.repository

import `in`.educool.compose.data.dto.auth.*
import `in`.educool.compose.data.network.ApiService
import `in`.educool.compose.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val apiService: ApiService) : AuthRepository {

    override suspend fun login(body: LoginBodyDTO): LoginDTO = apiService.login(body)

    override suspend fun signup(body: LoginBodyDTO): SignUpDTO = apiService.signUp(body)

    override suspend fun verifyOtp(body: VerifyOtpBodyDTO): MessageDTO = apiService.verifyOtp(body)

    override suspend fun resetPassword(email: String, new_password: String): MessageDTO = apiService.resetPassword(email, new_password)

    override suspend fun sendOtp(email: String): MessageDTO = apiService.sendOtp(email)

    override suspend fun generateTokens(email: String, password: String): TokenDTO = apiService.generateTokens(email, password)

    override suspend fun generateAccessToken(refresh: String): TokenDTO = apiService.generateAccessToken(refresh)
}

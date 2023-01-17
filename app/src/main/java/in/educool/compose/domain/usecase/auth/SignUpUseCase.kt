package `in`.educool.compose.domain.usecase.auth

import `in`.educool.compose.common.ApiState
import `in`.educool.compose.data.dto.auth.LoginBodyDTO
import `in`.educool.compose.data.dto.auth.SignUpDTO
import `in`.educool.compose.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SignUpUseCase(private val authRepository: AuthRepository) {

    operator fun invoke(body: LoginBodyDTO): Flow<ApiState<SignUpDTO>> = flow {
        emit(ApiState.Loading())

        try {
            ApiState.Success(authRepository.signup(body))
        } catch (e: java.lang.Exception) {
            ApiState.Error(e.message.toString())
        }
    }
}

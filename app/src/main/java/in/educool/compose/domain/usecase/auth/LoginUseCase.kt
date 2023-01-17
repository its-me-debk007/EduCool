package `in`.educool.compose.domain.usecase.auth

import `in`.educool.compose.common.ApiState
import `in`.educool.compose.data.dto.auth.LoginBodyDTO
import `in`.educool.compose.data.dto.auth.LoginDTO
import `in`.educool.compose.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginUseCase(private val authRepository: AuthRepository) {

    operator fun invoke(body: LoginBodyDTO): Flow<ApiState<LoginDTO>> = flow {
        emit(ApiState.Loading())

        try {
            emit(ApiState.Success(authRepository.login(body)))
        } catch (e: java.lang.Exception) {
            emit(ApiState.Error(e.message.toString()))
        }
    }
}

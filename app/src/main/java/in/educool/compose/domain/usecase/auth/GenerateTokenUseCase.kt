package `in`.educool.compose.domain.usecase.auth

import `in`.educool.compose.common.ApiState
import `in`.educool.compose.data.dto.auth.TokenDTO
import `in`.educool.compose.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GenerateTokenUseCase(private val authRepository: AuthRepository) {

    operator fun invoke(email: String, password: String): Flow<ApiState<TokenDTO>> = flow {
        emit(ApiState.Loading())

        try {
            emit(ApiState.Success(authRepository.generateTokens(email, password)))
        } catch (e: java.lang.Exception) {
            emit(ApiState.Error(e.message.toString()))
        }
    }
}

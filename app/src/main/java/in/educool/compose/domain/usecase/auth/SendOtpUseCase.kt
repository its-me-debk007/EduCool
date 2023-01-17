package `in`.educool.compose.domain.usecase.auth

import `in`.educool.compose.common.ApiState
import `in`.educool.compose.data.dto.auth.MessageDTO
import `in`.educool.compose.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SendOtpUseCase(private val authRepository: AuthRepository) {

    operator fun invoke(email: String): Flow<ApiState<MessageDTO>> = flow {
        emit(ApiState.Loading())

        try {
            emit(ApiState.Success(authRepository.sendOtp(email)))
        } catch (e: java.lang.Exception) {
            emit(ApiState.Error(e.message.toString()))
        }
    }
}

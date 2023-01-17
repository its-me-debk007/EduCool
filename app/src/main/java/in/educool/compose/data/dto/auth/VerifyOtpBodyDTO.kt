package `in`.educool.compose.data.dto.auth

data class VerifyOtpBodyDTO(
    val email: String,
    val otp: String
)

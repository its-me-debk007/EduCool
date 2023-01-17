package `in`.educool.compose.data.dto.auth

data class TokenDTO(
    val access: String,
    val refresh: String? = null
)

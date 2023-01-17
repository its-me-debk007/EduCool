package `in`.educool.compose.domain.mapper

import `in`.educool.compose.data.dto.auth.MessageDTO
import `in`.educool.compose.data.dto.auth.SignUpDTO

fun SignUpDTO.toMessageDTO() = MessageDTO(message = this.message)

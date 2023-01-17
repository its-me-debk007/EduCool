package `in`.educool.compose.data.dto.auth

data class FacultyProfileBodyDTO(
    val college: String,
    val department: String,
    val dob: String,
    val gender: String,
    val name: String,
    val profile_pic_firebase: String
)

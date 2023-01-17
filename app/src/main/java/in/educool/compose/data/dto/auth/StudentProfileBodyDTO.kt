package `in`.educool.compose.data.dto.auth

data class StudentProfileBodyDTO(
    val name: String,
    val college: String,
    val course: String,
    val branch: String,
    val year: String,
    val gender: String,
    val dob: String,
    val profile_pic_firebase: String
)

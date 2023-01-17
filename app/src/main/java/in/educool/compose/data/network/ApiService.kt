package `in`.educool.compose.data.network

import `in`.educool.compose.data.dto.*
import `in`.educool.compose.data.dto.auth.*
import retrofit2.http.*

interface ApiService {

    @POST("account/signup/")
    fun signUp(
        @Body body: LoginBodyDTO
    ): SignUpDTO

    @POST("account/login/")
    fun login(
        @Body body: LoginBodyDTO
    ): LoginDTO

    @POST("account/otp-verify/")
    suspend fun verifyOtp(
        @Body body: VerifyOtpBodyDTO
    ): MessageDTO

    @FormUrlEncoded
    @POST("account/forgot-reset/")
    fun resetPassword(
        @Field("email") email: String,
        @Field("new_password") password: String
    ): MessageDTO

    @FormUrlEncoded
    @POST("account/send-otp/")
    fun sendOtp(
        @Field("email") email: String
    ): MessageDTO

    @POST("profile/student/")
    suspend fun createStudentProfile(
        @Body body: StudentProfileBodyDTO
    ): ProfileDetailsDTO

    @POST("profile/faculty/")
    suspend fun createFacultyProfile(
        @Body body: FacultyProfileBodyDTO
    ): ProfileDetailsDTO

    @FormUrlEncoded
    @POST("account/token/")
    fun generateTokens(
        @Field("email") email: String,
        @Field("password") password: String
    ): TokenDTO

    @FormUrlEncoded
    @POST("account/token/refresh/")
    suspend fun generateAccessToken(
        @Field("refresh") refresh: String
    ): TokenDTO

    @GET("profile/")
    fun getProfile(): ProfileDetailsDTO
}

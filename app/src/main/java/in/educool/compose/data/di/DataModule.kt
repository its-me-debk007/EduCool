package `in`.educool.compose.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import `in`.educool.compose.BuildConfig
import `in`.educool.compose.data.network.ApiService
import `in`.educool.compose.data.repository.AuthRepositoryImpl
import `in`.educool.compose.domain.repository.AuthRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun provideAuthRepository(apiService: ApiService): AuthRepository = AuthRepositoryImpl(apiService)
}

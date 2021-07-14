package com.example.application_dagger_hilt_retrofit.module
import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.application_dagger_hilt_retrofit.BuildConfig
import com.example.application_dagger_hilt_retrofit.data.api.ApiHelper
import com.example.application_dagger_hilt_retrofit.data.api.ApiHelperImpl
import com.example.application_dagger_hilt_retrofit.data.api.ApiService
import com.example.application_dagger_hilt_retrofit.data.model.UserDataBase
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.moshi.MoshiConverterFactory

@InstallIn(SingletonComponent::class)
@Module(includes = [UserDataBaseModule::class])

class ApplicationModule {
    @Provides
    @Singleton
    fun providerContext(@ApplicationContext context: Context): Context {
        return context
    }

    val BASE_URL = "https://reqres.in/api/"
    @Provides
    fun provideBaseUrl() = BASE_URL
    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        BASE_URL: String
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper
}
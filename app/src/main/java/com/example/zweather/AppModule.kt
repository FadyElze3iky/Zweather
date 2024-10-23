package com.example.zweather

import com.example.zweather.app.data.WeatherApiService
import com.example.zweather.app.data.WeatherRepositoryImpl
import com.example.zweather.app.domain.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object WeatherModule {

    @Provides
    fun provideWeatherApiService(): WeatherApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)

        return retrofit
    }

    @Provides
    fun provideWeatherRepository(apiService: WeatherApiService): WeatherRepository {
        return WeatherRepositoryImpl(apiService)
    }

}
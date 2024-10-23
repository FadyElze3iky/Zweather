package com.example.zweather.app.data

import com.example.zweather.app.domain.WeatherData
import com.example.zweather.app.domain.WeatherRepository
import com.example.zweather.core.apiKey
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: WeatherApiService,
) : WeatherRepository {

    override suspend fun getWeather(location: String, days: Int): WeatherData {
        val response = apiService.getWeather(apiKey, location, days)

        return response.toDomain()
    }
}

package com.example.zweather.features.data

import com.example.zweather.core.apiKey
import com.example.zweather.features.domain.WeatherData
import com.example.zweather.features.domain.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: WeatherApiService,
) : WeatherRepository {

    override suspend fun getWeather(location: String, days: Int): WeatherData {
        val response = apiService.getWeather(apiKey, location, days)
        return response.toDomain()
    }
}

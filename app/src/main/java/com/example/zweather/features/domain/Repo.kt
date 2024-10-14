package com.example.zweather.features.domain

interface WeatherRepository {

    suspend fun getWeather(location: String, days: Int): WeatherData
}

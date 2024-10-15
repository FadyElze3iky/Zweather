package com.example.zweather.app.domain

interface WeatherRepository {

    suspend fun getWeather(location: String, days: Int): WeatherData
}

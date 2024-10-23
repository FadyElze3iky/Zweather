package com.example.zweather.app.data

import com.example.zweather.app.domain.AirQuality
import com.example.zweather.app.domain.Astro
import com.example.zweather.app.domain.Condition
import com.example.zweather.app.domain.Condition2
import com.example.zweather.app.domain.Condition3
import com.example.zweather.app.domain.Current
import com.example.zweather.app.domain.Day
import com.example.zweather.app.domain.Forecast
import com.example.zweather.app.domain.Forecastday
import com.example.zweather.app.domain.Hour
import com.example.zweather.app.domain.Location
import com.example.zweather.app.domain.WeatherData

fun WeatherResponse.toDomain(): WeatherData {
    return WeatherData(
        location = this.location?.let {
            Location(
                name = this.location.name,
                region = this.location.region,
                country = this.location.country,
                lat = this.location.lat,
                lon = this.location.lon,
                tzId = this.location.tzId,
                localtimeEpoch = this.location.localtimeEpoch,
                localtime = this.location.localtime
            )
        },
        current = this.current?.let {
            Current(
                lastUpdatedEpoch = this.current.lastUpdatedEpoch,
                lastUpdated = this.current.lastUpdated,
                tempC = this.current.tempC,
                tempF = this.current.tempF,
                isDay = this.current.isDay,
                condition = Condition(
                    text = this.current.condition?.text,
                    icon = this.current.condition?.icon,
                    code = this.current.condition?.code
                ),
                windMph = this.current.windMph,
                windKph = this.current.windKph,
                windDegree = this.current.windDegree,
                windDir = this.current.windDir,
                pressureMb = this.current.pressureMb,
                pressureIn = this.current.pressureIn,
                precipMm = this.current.precipMm,
                precipIn = this.current.precipIn,
                humidity = this.current.humidity,
                cloud = this.current.cloud,
                feelslikeC = this.current.feelslikeC,
                feelslikeF = this.current.feelslikeF,
                windchillC = this.current.windchillC,
                windchillF = this.current.windchillF,
                heatindexC = this.current.heatindexC,
                heatindexF = this.current.heatindexF,
                dewpointC = this.current.dewpointC,
                dewpointF = this.current.dewpointF,
                visKm = this.current.visKm,
                visMiles = this.current.visMiles,
                uv = this.current.uv,
                gustMph = this.current.gustMph,
                gustKph = this.current.gustKph,
                airQuality = AirQuality(
                    co = this.current.airQuality?.co,
                    no2 = this.current.airQuality?.no2,
                    o3 = this.current.airQuality?.o3,
                    so2 = this.current.airQuality?.so2,
                    pm25 = this.current.airQuality?.pm25,
                    pm10 = this.current.airQuality?.pm10,
                    usEpaIndex = this.current.airQuality?.usEpaIndex,
                    gbDefraIndex = this.current.airQuality?.gbDefraIndex
                )
            )
        },

        forecast = this.forecast?.let {
            Forecast(
                forecastday = forecast.forecastday.map { forecastday ->
                    Forecastday(
                        date = forecastday.date,
                        dateEpoch = forecastday.dateEpoch,
                        day = forecastday.day.let { day ->
                            Day(
                                maxtempC = day.maxtempC,
                                maxtempF = day.maxtempF,
                                mintempC = day.mintempC,
                                mintempF = day.mintempF,
                                avgtempC = day.avgtempC,
                                avgtempF = day.avgtempF,
                                maxwindMph = day.maxwindMph,
                                maxwindKph = day.maxwindKph,
                                totalprecipMm = day.totalprecipMm,
                                totalprecipIn = day.totalprecipIn,
                                totalsnowCm = day.totalsnowCm,
                                avgvisKm = day.avgvisKm,
                                avgvisMiles = day.avgvisMiles,
                                avghumidity = day.avghumidity,
                                dailyWillItRain = day.dailyWillItRain,
                                dailyChanceOfRain = day.dailyChanceOfRain,
                                dailyWillItSnow = day.dailyWillItSnow,
                                dailyChanceOfSnow = day.dailyChanceOfSnow,
                                condition = day.condition?.let { condition2 ->
                                    Condition2(
                                        text = condition2.text,
                                        icon = condition2.icon,
                                        code = condition2.code
                                    )
                                },
                                uv = day.uv
                            )
                        },
                        astro = forecastday.astro.let { astro ->
                            Astro(
                                sunrise = astro.sunrise,
                                sunset = astro.sunset,
                                moonrise = astro.moonrise,
                                moonset = astro.moonset,
                                moonPhase = astro.moonPhase,
                                moonIllumination = astro.moonIllumination,
                                isMoonUp = astro.isMoonUp,
                                isSunUp = astro.isSunUp
                            )
                        },
                        hour = forecastday.hour.map { hour ->
                            Hour(
                                timeEpoch = hour.timeEpoch,
                                time = hour.time,
                                tempC = hour.tempC,
                                tempF = hour.tempF,
                                isDay = hour.isDay,
                                condition = hour.condition?.let { condition3 ->
                                    Condition3(
                                        text = condition3.text,
                                        icon = condition3.icon,
                                        code = condition3.code
                                    )
                                },
                                windMph = hour.windMph,
                                windKph = hour.windKph,
                                windDegree = hour.windDegree,
                                windDir = hour.windDir,
                                pressureMb = hour.pressureMb,
                                pressureIn = hour.pressureIn,
                                precipMm = hour.precipMm,
                                precipIn = hour.precipIn,
                                snowCm = hour.snowCm,
                                humidity = hour.humidity,
                                cloud = hour.cloud,
                                feelslikeC = hour.feelslikeC,
                                feelslikeF = hour.feelslikeF,
                                windchillC = hour.windchillC,
                                windchillF = hour.windchillF,
                                heatindexC = hour.heatindexC,
                                heatindexF = hour.heatindexF,
                                dewpointC = hour.dewpointC,
                                dewpointF = hour.dewpointF,
                                willItRain = hour.willItRain,
                                chanceOfRain = hour.chanceOfRain,
                                willItSnow = hour.willItSnow,
                                chanceOfSnow = hour.chanceOfSnow,
                                visKm = hour.visKm,
                                visMiles = hour.visMiles,
                                gustMph = hour.gustMph,
                                gustKph = hour.gustKph,
                                uv = hour.uv
                            )
                        }
                    )
                }
            )
        },

        )
}



package com.example.zweather.app.data

import com.example.zweather.app.domain.Location
import com.example.zweather.app.domain.WeatherData

fun WeatherResponse.toDomain(): WeatherData {
    return WeatherData(
        location = this.location?.name?.let {
            Location(
                name = it,
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
                lastUpdatedEpoch = it.lastUpdatedEpoch,
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
        forecast = this.forecast?.forecastday?.map { forecastDay ->
            Forecastday(
                date = forecastDay.date,
                dateEpoch = forecastDay.dateEpoch,
                day = Day(
                    maxtempC = forecastDay.day.maxtempC,
                    maxtempF = forecastDay.day.maxtempF,
                    mintempC = forecastDay.day.mintempC,
                    mintempF = forecastDay.day.mintempF,
                    avgtempC = forecastDay.day.avgtempC,
                    avgtempF = forecastDay.day.avgtempF,
                    maxwindMph = forecastDay.day.maxwindMph,
                    maxwindKph = forecastDay.day.maxwindKph,
                    totalprecipMm = forecastDay.day.totalprecipMm,
                    totalprecipIn = forecastDay.day.totalprecipIn,
                    totalsnowCm = forecastDay.day.totalsnowCm,
                    avgvisKm = forecastDay.day.avgvisKm,
                    avgvisMiles = forecastDay.day.avgvisMiles,
                    avghumidity = forecastDay.day.avghumidity,
                    dailyWillItRain = forecastDay.day.dailyWillItRain,
                    dailyChanceOfRain = forecastDay.day.dailyChanceOfRain,
                    dailyWillItSnow = forecastDay.day.dailyWillItSnow,
                    dailyChanceOfSnow = forecastDay.day.dailyChanceOfSnow,
                    condition = Condition2(
                        text = forecastDay.day.condition?.text,
                        icon = forecastDay.day.condition?.icon,
                        code = forecastDay.day.condition?.code
                    ),
                    uv = forecastDay.day.uv
                ),
                astro = Astro(
                    sunrise = forecastDay.astro.sunrise,
                    sunset = forecastDay.astro.sunset,
                    moonrise = forecastDay.astro.moonrise,
                    moonset = forecastDay.astro.moonset,
                    moonPhase = forecastDay.astro.moonPhase,
                    moonIllumination = forecastDay.astro.moonIllumination,
                    isMoonUp = forecastDay.astro.isMoonUp,
                    isSunUp = forecastDay.astro.isSunUp
                ),
                hour = forecastDay.hour.map { hour ->
                    Hour(
                        timeEpoch = hour.timeEpoch,
                        time = hour.time,
                        tempC = hour.tempC,
                        tempF = hour.tempF,
                        isDay = hour.isDay,
                        condition = Condition3(
                            text = hour.condition?.text,
                            icon = hour.condition?.icon,
                            code = hour.condition?.code
                        ),
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
}

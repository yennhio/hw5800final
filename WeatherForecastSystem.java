package hw5800final.Final.weatherforecast;

import java.util.ArrayList;
import java.util.List;

public class WeatherForecastSystem {
    List<WeatherService> weatherServices;

    public WeatherForecastSystem(WeatherService... weatherServices) {
        this.weatherServices = new ArrayList<>();

        for (WeatherService weatherService : weatherServices) {
            this.weatherServices.add(weatherService);
        }
    }

    public void getWeather() {
        for (WeatherService weatherService : weatherServices) {
            weatherService.getWeatherData();
        }

    }




    
}
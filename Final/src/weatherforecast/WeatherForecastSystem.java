package weatherforecast;

public class WeatherForecastSystem {
    WeatherService weatherService;

    public WeatherForecastSystem() {
    }

    public void getWeather(WeatherService... weatherServices) {
        for (WeatherService weatherService : weatherServices) {
            weatherService.getWeatherData();
        }

    }




    
}
package hw5800final.Final.weatherforecast;

public interface WeatherService {
    void getWeatherData();
    void sendNotifs();
    void registerUser(User user, String... properties);
}
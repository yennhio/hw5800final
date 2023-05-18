package weatherforecast;

public interface WeatherService {
    void getWeatherData();
    void sendNotifs();
    void registerUser(User user, String... properties);
}
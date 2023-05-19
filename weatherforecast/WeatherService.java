package weatherforecast;

public interface WeatherService {
    void getWeatherData();
    void sendNotifs(String property);
    void registerUser(User user, String... properties);
}
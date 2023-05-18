package weatherforecast;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void subscribeToService(WeatherService weatherService, String... properties) {
        weatherService.registerUser(this, properties);
    }


}
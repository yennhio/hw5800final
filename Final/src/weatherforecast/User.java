package weatherforecast;

import java.time.LocalTime;


public class User {
    private String name;
    LocalTime currentTime = LocalTime.now();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void subscribeToService(WeatherService weatherService, String... properties) {
        weatherService.registerUser(this, properties);
    }

    public void receiveNotifs(WeatherService weatherService, String property, double level) {
        System.out.println(name + " receiving notifs from " + weatherService);
        System.out.println(property + " " + level + " at " + currentTime);
    }
}
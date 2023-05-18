package weatherforecast;

import java.util.HashMap;

public class WeatherApi implements WeatherService, WeatherObserver {

    private WeatherServiceSubject weatherSubject;
    private HashMap<String, User> subscribers = new HashMap<>();


    public WeatherApi (WeatherServiceSubject weatherSubject){
        subscribers = new HashMap<>();
        this.weatherSubject = weatherSubject;
        this.weatherSubject.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Updating WeatherAPI ");
        System.out.println("Temperature: " + weatherSubject.getTemp()*9/5+32 + " degrees F");
        System.out.println("Humidity: " + weatherSubject.getHumidity() + "%");
        System.out.println("Precipitation: " + weatherSubject.getPrecip() + "%");
        
    }

    @Override
    public void getWeatherData() {
        System.out.println("WeatherAPI ");
        System.out.println("Temperature: " + weatherSubject.getTemp()*9/5+32 + " degrees F");
        System.out.println("Humidity: " + weatherSubject.getHumidity() + "%");
        System.out.println("Precipitation: " + weatherSubject.getPrecip() + "%");
    }

    @Override
    public void sendNotifs() {
        
    }

    @Override 
    public void registerUser(User user, String... properties) {
        for (String property : properties) {
            subscribers.put(property, user);
        }
    }
}

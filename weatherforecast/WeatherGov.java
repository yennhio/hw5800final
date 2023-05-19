package weatherforecast;

import java.util.HashMap;
import java.util.Map;

public class WeatherGov implements WeatherService, WeatherObserver {

    private WeatherServiceSubject weatherSubject;
    private HashMap<String, User> subscribers = new HashMap<>();


    public WeatherGov (WeatherServiceSubject weatherSubject){
        subscribers = new HashMap<>();
        this.weatherSubject = weatherSubject;
        this.weatherSubject.registerObserver(this);
    }

    @Override
    public void update(String property) {
        System.out.println("Updating Weather.gov ");
        System.out.println("Temperature: " + weatherSubject.getTemp()+273.15 + " K");
        System.out.println("Absolute Humidity: " + weatherSubject.getHumidity()/2 + "%");
        System.out.println("Precipitation: " + weatherSubject.getPrecip()/0.1 + "mm");
        sendNotifs(property);
    }

    @Override
    public void getWeatherData() {
        System.out.println("Weather.gov ");
        System.out.println("Temperature: " + weatherSubject.getTemp()+273.15 + " K");
        System.out.println("Absolute Humidity: " + weatherSubject.getHumidity()/2 + "%");
        System.out.println("Precipitation: " + weatherSubject.getPrecip()/0.1 + "mm");
    }

    @Override
    public void sendNotifs(String property) {
        for (Map.Entry<String, User> subscriber : subscribers.entrySet()) {
            String prop = subscriber.getKey();
            User userToReceiveNotif;
            if (prop.equals("humidity") && prop.equals(property)) {
                userToReceiveNotif = subscriber.getValue(); 
                userToReceiveNotif.receiveNotifs(this, prop, weatherSubject.getHumidity()/2);
            }
            else if (prop.equals("temperature") && prop.equals(property)) {
                userToReceiveNotif = subscriber.getValue(); 
                userToReceiveNotif.receiveNotifs(this, prop, weatherSubject.getTemp()+273.15);
            }
            else if (prop.equals("precipitation") && prop.equals(property)){
                userToReceiveNotif = subscriber.getValue(); 
                userToReceiveNotif.receiveNotifs(this, prop, weatherSubject.getPrecip()/0.1);
            }
        }
        
    }

    @Override 
    public void registerUser(User user, String... properties) {
        for (String property : properties) {
            subscribers.put(property, user);
            System.out.println(user.getName() + " subscribing to Weather.gov for " + property);
        }
    }
}

package weatherforecast;

import java.util.HashMap;
import java.util.Map;

public class WeatherApi implements WeatherService, WeatherObserver {

    private WeatherServiceSubject weatherSubject;
    private HashMap<String, User> subscribers = new HashMap<>();


    public WeatherApi (WeatherServiceSubject weatherSubject){
        subscribers = new HashMap<>();
        this.weatherSubject = weatherSubject;
        this.weatherSubject.registerObserver(this);
    }

    @Override
    public void update(String property) {
        System.out.println("Updating WeatherAPI ");
        System.out.println("Temperature: " + ((weatherSubject.getTemp()*9/5)+32) + " degrees F");
        System.out.println("Humidity: " + weatherSubject.getHumidity() + "%");
        System.out.println("Precipitation: " + weatherSubject.getPrecip() + "%");
        sendNotifs(property);
    }

    @Override
    public void getWeatherData() {
        System.out.println("WeatherAPI ");
        System.out.println("Temperature: " + ((weatherSubject.getTemp()*9/5)+32) + " degrees F");
        System.out.println("Humidity: " + weatherSubject.getHumidity() + "%");
        System.out.println("Precipitation: " + weatherSubject.getPrecip() + "%");
    }

    @Override
    public void sendNotifs(String property) {
        for (Map.Entry<String, User> subscriber : subscribers.entrySet()) {
            String prop = subscriber.getKey();
            User userToReceiveNotif;
            if (prop.equals("humidity") && prop.equals(property)) {
                userToReceiveNotif = subscriber.getValue(); 
                userToReceiveNotif.receiveNotifs(this, prop, weatherSubject.getHumidity());
            }
            else if (prop.equals("temperature") && prop.equals(property)) {
                userToReceiveNotif = subscriber.getValue(); 
                userToReceiveNotif.receiveNotifs(this, prop, (weatherSubject.getTemp()*9/5+32));
            }
            else if (prop.equals("precipitation") && prop.equals(property)){
                userToReceiveNotif = subscriber.getValue(); 
                userToReceiveNotif.receiveNotifs(this, prop, weatherSubject.getPrecip());
            }
        }
        
    }

    @Override 
    public void registerUser(User user, String... properties) {
        for (String property : properties) {
            subscribers.put(property, user);
            System.out.println(user.getName() + " subscribing to WeatherAPI for " + property);
        }
    }
}

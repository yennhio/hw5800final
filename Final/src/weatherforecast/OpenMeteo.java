package weatherforecast;

import java.util.HashMap;
import java.util.Map;

public class OpenMeteo implements WeatherService, WeatherObserver {

    private WeatherServiceSubject weatherSubject;
    private HashMap<String, User> subscribers = new HashMap<>();


    public OpenMeteo (WeatherServiceSubject weatherSubject){
        subscribers = new HashMap<>();
        this.weatherSubject = weatherSubject;
        this.weatherSubject.registerObserver(this);
    }

    @Override
    public void update(String property) {
        System.out.println("Updating OpenMeteo");
        System.out.println("Temperature: " + weatherSubject.getTemp() + " degrees C");
        System.out.println("Humidity dew point: " + weatherSubject.getHumidity()/2 + " degrees C Td");
        System.out.println("Precipitation: " + weatherSubject.getPrecip()/6 + " cm");
        sendNotifs(property);
    }

    @Override
    public void getWeatherData() {
        System.out.println("OpenMeteo");
        System.out.println("Temperature: " + weatherSubject.getTemp() + " degrees C");
        System.out.println("Humidity dew point: " + weatherSubject.getHumidity()/2 + " degrees C Td");
        System.out.println("Precipitation: " + weatherSubject.getPrecip()/6 + " cm");
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
                userToReceiveNotif.receiveNotifs(this, prop, weatherSubject.getTemp());
            }
            else if (prop.equals("precipitation") && prop.equals(property)){
                userToReceiveNotif = subscriber.getValue(); 
                userToReceiveNotif.receiveNotifs(this, prop, weatherSubject.getPrecip()/6);
            }
        }
        
    }

    @Override 
    public void registerUser(User user, String... properties) {
        for (String property : properties) {
            subscribers.put(property, user);
            System.out.println(user.getName() + " subscribing to OpenMeteo for " + property);
        }
    }
}

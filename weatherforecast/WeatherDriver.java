package weatherforecast;

public class WeatherDriver {

    public static void main (String[] args) {

        WeatherServiceSubject weatherSubject = new WeatherServiceSubject(30, 20, 25);
        WeatherApi weatherApi = new WeatherApi(weatherSubject);
        WeatherGov weatherGov = new WeatherGov(weatherSubject);
        OpenMeteo openMeteo = new OpenMeteo(weatherSubject);

        WeatherForecastSystem forecast = new WeatherForecastSystem();
        User bob = new User("Bob");
        User alice = new User("Alice");


        System.out.println("Initial weather:");
        forecast.getWeather(weatherApi, weatherGov, openMeteo);

        bob.subscribeToService(weatherApi, "temperature", "precipitation");
        alice.subscribeToService(openMeteo, "humidity");


        weatherSubject.setTemp(24);

        weatherSubject.setPrecip(34);

        weatherSubject.setHumidity(40);


    }
    
}

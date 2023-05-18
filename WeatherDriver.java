package hw5800final.Final.weatherforecast;

public class WeatherDriver {

    public static void main (String[] args) {

        WeatherServiceSubject weatherSubject = new WeatherServiceSubject(30, 20, 25);
        WeatherApi weatherApi = new WeatherApi(weatherSubject);
        WeatherForecastSystem forecast = new WeatherForecastSystem(weatherApi);
        User bob = new User("Bob");

        System.out.println("First weather update");
        weatherSubject.setHumidity(25);

        forecast.getWeather();

        bob.subscribeToService(weatherApi);

    }
    
}

package weatherforecast;

public interface WeatherSubject {
    void registerObserver(WeatherObserver weatherObserver);
    void removeObserver(WeatherObserver observer);
    void notifyObservers();
    void setWeather(double precip, double humidity, double temp);
}

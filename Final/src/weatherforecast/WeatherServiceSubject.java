package weatherforecast;

import java.util.ArrayList;
import java.util.List;

public class WeatherServiceSubject implements WeatherSubject {
    private List<WeatherObserver> observers;
    private double precip;
    private double humidity;
    private double temp;

    public WeatherServiceSubject(double precip, double humidity, double temp) {
        this.observers = new ArrayList<>();
        this.temp = temp;
        this.precip = precip;
        this.humidity = humidity;
    }

    public double getTemp() {
        return temp;
    }    

    public double getPrecip() {
        return precip;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setTemp(double temp) {
        this.temp = temp;
        System.out.println("Updating temperature");
        for (WeatherObserver observer : observers) {
            observer.update("temperature");
        }
    }

    public void setPrecip(double precip) {
        this.precip = precip;
        System.out.println("Updating precipitation");
        for (WeatherObserver observer : observers) {
            observer.update("precipitation");
        }
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
        System.out.println("Updating humidity");
        for (WeatherObserver observer : observers) {
            observer.update("humidity");
        }    }

    @Override
    public void setWeather(double precip, double humidity, double temp) {
        this.temp = temp;
        this.precip = precip;
        this.humidity = humidity;
        System.out.println("Updating weather");
        notifyObservers();
    }

    @Override
    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(null);
        }
    }

  
}


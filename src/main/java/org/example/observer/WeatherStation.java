package org.example.observer;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80,30, 22);
        weatherData.setMeasurements(81,31, 23);
        weatherData.setMeasurements(82,32, 24);
        weatherData.setMeasurements(83,33, 25);
    }
}

package org.example.observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temp;
    private float humidity;
    private float pressure;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.printf("Current Condition: temperature = %f , humidity = %f , pressure = %f %n", temp, humidity, pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}

package com.groupbuddies.weather;

/**
 * Created by joaojusto on 31/03/15.
 */
public class Forecast {

    private double temp;
    private double maxTemp;
    private double minTemp;
    private String weather;
    private String description;

    public Forecast() {}

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public int getIntMaxTemperature() {
        return (int) this.maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public int getIntMinTemperature() {
        return (int) this.minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.groupbuddies.weather;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by joaojusto on 30/03/15.
 */
public class City {
    private int id;
    private int clouds;
    private int humidity;

    private double pressure;
    private double seaLevel;
    private double windSpeed;
    private double groundLevel;
    private double temperature;
    private double windDirection;
    private double minTemperature;
    private double maxTemperature;

    private String name;
    private String coord;
    private String country;
    private String weather;
    private String weatherDescription;

    private ArrayList<Forecast> forecast = new ArrayList<>();

    public City() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getGroundLevel() {
        return groundLevel;
    }

    public void setGroundLevel(double groundLevel) {
        this.groundLevel = groundLevel;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public int getIntMinTemperature() {
        return (int) minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public int getIntMaxTemperature() {
        return (int) maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoord() {
        return coord;
    }

    public void setCoord(String coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public ArrayList<Forecast> getForecasts() {
        return forecast;
    }

    public void addForecast(Forecast forecast) {
        this.forecast.add(forecast);
    }

    public Forecast getForecast(int i) {
        return this.forecast.get(i);
    }

    @Override
    public String toString() {
     return this.name + ", " + this.weatherDescription + ", " + this.temperature + "º";
    }
}

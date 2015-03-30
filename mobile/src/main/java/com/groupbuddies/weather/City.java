package com.groupbuddies.weather;

import org.json.JSONException;
import org.json.JSONObject;

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

    public City(JSONObject jsonCity) {
        this.parseWind(jsonCity);
        this.parseClouds(jsonCity);
        this.parseCountry(jsonCity);
        this.parseIdAndName(jsonCity);
        this.parseDescription(jsonCity);
        this.parseTemperatureAndAltitude(jsonCity);
    }

    private void parseIdAndName(JSONObject jsonCity) {
        try {
            this.id = (Integer) jsonCity.get("id");
            this.name = jsonCity.get("name").toString();
            this.coord = jsonCity.get("coord").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseTemperatureAndAltitude(JSONObject jsonCity) {
        try {
            JSONObject temperatureObject = jsonCity.getJSONObject("main");

            this.humidity = (Integer) temperatureObject.get("humidity");

            this.temperature = Double.parseDouble(temperatureObject.get("temp").toString());
            this.minTemperature = Double.parseDouble(temperatureObject.get("temp_min").toString());
            this.maxTemperature =  Double.parseDouble(temperatureObject.get("temp_max").toString());

            this.pressure = (Integer) temperatureObject.get("pressure");
            this.seaLevel = Double.parseDouble(temperatureObject.get("sea_level").toString());
            this.groundLevel = Double.parseDouble(temperatureObject.get("grnd_level").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseWind(JSONObject jsonCity) {
        try {
            JSONObject windObject = jsonCity.getJSONObject("wind");

            this.windSpeed = Double.parseDouble(windObject.get("speed").toString());
            this.windDirection = Double.parseDouble(windObject.get("deg").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseCountry(JSONObject jsonCity) {
        try {
            JSONObject sysObject = jsonCity.getJSONObject("sys");

            this.country = sysObject.get("country").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseClouds(JSONObject jsonCity) {
        try {
            JSONObject cloudsObject = jsonCity.getJSONObject("clouds");

            this.clouds = (Integer) cloudsObject.get("all");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseDescription(JSONObject jsonCity) {
        try {
            JSONObject descriptionObject = (JSONObject) jsonCity.getJSONArray("weather").get(0);

            this.weather = descriptionObject.get("main").toString();
            this.weatherDescription = descriptionObject.get("description").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
     return this.name + ", " + this.weatherDescription + ", " + this.temperature + "º";
    }
}

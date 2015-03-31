package com.groupbuddies.weather;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by joaojusto on 31/03/15.
 */
public class CityParser {

    public static City parseCity(JSONObject jsonCity) {
        City city = new City();

        try {
            CityParser.parseWind(jsonCity, city);
            CityParser.parseClouds(jsonCity, city);
            CityParser.parseCountry(jsonCity, city);
            CityParser.parseIdAndName(jsonCity, city);
            CityParser.parseDescription(jsonCity, city);
            CityParser.parseTemperatureAndAltitude(jsonCity, city);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return city;
    }

    private static void parseIdAndName(JSONObject jsonCity, City city) throws JSONException {
        city.setId((Integer) jsonCity.get("id"));
        city.setName(jsonCity.get("name").toString());
        city.setCoord(jsonCity.get("coord").toString());
    }

    private static void parseTemperatureAndAltitude(JSONObject jsonCity, City city) throws JSONException {
        JSONObject temperatureObject = jsonCity.getJSONObject("main");

        city.setHumidity((Integer) temperatureObject.get("humidity"));

        city.setTemperature(Double.parseDouble(temperatureObject.get("temp").toString()));
        city.setMinTemperature(Double.parseDouble(temperatureObject.get("temp_min").toString()));
        city.setMaxTemperature(Double.parseDouble(temperatureObject.get("temp_max").toString()));

        city.setPressure(Double.parseDouble(temperatureObject.get("pressure").toString()));
        city.setSeaLevel(Double.parseDouble(temperatureObject.get("sea_level").toString()));
        city.setGroundLevel(Double.parseDouble(temperatureObject.get("grnd_level").toString()));
    }

    private static void parseWind(JSONObject jsonCity, City city) throws JSONException {
        JSONObject windObject = jsonCity.getJSONObject("wind");

        city.setWindSpeed(Double.parseDouble(windObject.get("speed").toString()));
        city.setWindDirection(Double.parseDouble(windObject.get("deg").toString()));
    }

    private static void parseCountry(JSONObject jsonCity, City city) throws JSONException {
        JSONObject sysObject = jsonCity.getJSONObject("sys");

        city.setCountry(sysObject.get("country").toString());
    }

    private static void parseClouds(JSONObject jsonCity, City city) throws JSONException {
        JSONObject cloudsObject = jsonCity.getJSONObject("clouds");

        city.setClouds((Integer) cloudsObject.get("all"));
    }

    private static void parseDescription(JSONObject jsonCity, City city) throws JSONException {
        JSONObject descriptionObject = (JSONObject) jsonCity.getJSONArray("weather").get(0);

        city.setWeather(descriptionObject.get("main").toString());
        city.setWeatherDescription(descriptionObject.get("description").toString());
    }
}

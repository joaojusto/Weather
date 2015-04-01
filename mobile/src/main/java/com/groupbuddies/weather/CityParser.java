package com.groupbuddies.weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by joaojusto on 31/03/15.
 */
public class CityParser {

    public static City parseCity(String jsonCity) {
        City city = new City();
        JSONObject jsonCityObject = parseJSON(jsonCity);
        try {
            JSONArray jsonArray = jsonCityObject.getJSONArray("list");
            JSONObject cityInfo = jsonCityObject.getJSONObject("city");
            JSONObject cityNow = jsonArray.getJSONObject(0);

            for (int i = 1; i < jsonArray.length(); i++) {
                parseForecast(jsonArray.getJSONObject(i), city);
            }

            CityParser.parseWind(cityNow, city);
            CityParser.parseClouds(cityNow, city);
            CityParser.parseCountry(cityInfo, city);
            CityParser.parseIdAndName(cityInfo, city);
            CityParser.parseDescription(cityNow, city);
            CityParser.parseTemperatureAndAltitude(cityNow, city);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return city;
    }

    private static JSONObject parseJSON(String jsonString) {
        JSONObject parsedJSON = null;

        try {
            parsedJSON = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return parsedJSON;
    }

    private static void parseIdAndName(JSONObject jsonCity, City city) throws JSONException {
        city.setId((Integer) jsonCity.get("id"));
        city.setName(jsonCity.get("name").toString());
        city.setCoord(jsonCity.get("coord").toString());
    }

    private static void parseTemperatureAndAltitude(JSONObject jsonCity, City city) throws JSONException {
        JSONObject temperatureObject = jsonCity.getJSONObject("temp");

        city.setHumidity((Integer) jsonCity.get("humidity"));

        city.setTemperature(Double.parseDouble(temperatureObject.get("day").toString()));
        city.setMinTemperature(Double.parseDouble(temperatureObject.get("min").toString()));
        city.setMaxTemperature(Double.parseDouble(temperatureObject.get("max").toString()));
        city.setNightTemperature(Double.parseDouble(temperatureObject.get("night").toString()));
        city.setMorningTemperature(Double.parseDouble(temperatureObject.get("morn").toString()));
        city.setEveningTemperature(Double.parseDouble(temperatureObject.get("eve").toString()));

        city.setPressure(Double.parseDouble(jsonCity.get("pressure").toString()));
    }

    private static void parseWind(JSONObject jsonCity, City city) throws JSONException {
        city.setWindSpeed(Double.parseDouble(jsonCity.get("speed").toString()));
        city.setWindDirection(Double.parseDouble(jsonCity.get("deg").toString()));
    }

    private static void parseCountry(JSONObject jsonCity, City city) throws JSONException {
        city.setCountry(jsonCity.get("country").toString());
    }

    private static void parseClouds(JSONObject jsonCity, City city) throws JSONException {
        city.setClouds((Integer) jsonCity.get("clouds"));
    }

    private static void parseDescription(JSONObject jsonCity, City city) throws JSONException {
        JSONObject descriptionObject = (JSONObject) jsonCity.getJSONArray("weather").get(0);

        city.setWeather(descriptionObject.get("icon").toString());
        city.setWeatherDescription(descriptionObject.get("description").toString());
    }

    private static void parseForecast(JSONObject jsonForecast, City city) throws JSONException {
        Forecast forecast = new Forecast();

        JSONObject temperatureObject = jsonForecast.getJSONObject("temp");
        JSONObject weatherDescription = jsonForecast.getJSONArray("weather").getJSONObject(0);

        forecast.setTemp(Double.parseDouble(temperatureObject.get("day").toString()));
        forecast.setMaxTemp(Double.parseDouble(temperatureObject.get("max").toString()));
        forecast.setMinTemp(Double.parseDouble(temperatureObject.get("min").toString()));
        forecast.setWeather(weatherDescription.get("icon").toString());
        forecast.setDescription(weatherDescription.get("description").toString());

        city.addForecast(forecast);
    }
}

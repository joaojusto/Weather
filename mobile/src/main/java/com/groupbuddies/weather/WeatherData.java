package com.groupbuddies.weather;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by joaojusto on 30/03/15.
 */
public class WeatherData extends AsyncTask<String, Integer, String> {
    private City city;
    private TextView weatherInformation;

    public WeatherData(TextView weatherInformation) {
        this.weatherInformation = weatherInformation;
    }

    protected String doInBackground(String... urls) {
        String url = urls[0];

        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);

        try {
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
            } else {
                Log.e("WeatherData", "Failed to download file");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    protected void onProgressUpdate(Integer... progress) {
    }

    protected void onPostExecute(String result) {
        this.city = new City(parseJSON(result));

        this.weatherInformation.setText(this.city.toString());
        Log.i("WeatherData", result);
    }

    private JSONObject parseJSON(String jsonString) {
        JSONObject parsedJSON = null;

        try {
            parsedJSON = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return parsedJSON;
    }
}

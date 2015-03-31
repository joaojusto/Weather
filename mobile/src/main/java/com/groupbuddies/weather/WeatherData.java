package com.groupbuddies.weather;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by joaojusto on 30/03/15.
 */
public class WeatherData extends AsyncTask<String, Integer, String> {
    private City city;

    private RelativeLayout weatherInformation = null;
    private RelativeLayout weekDayInformation = null;
    private RelativeLayout loadingInformation = null;

    public WeatherData(RelativeLayout weatherInformation, RelativeLayout weekDayInformation, RelativeLayout loadingInformation) {
        this.weatherInformation = weatherInformation;
        this.weekDayInformation = weekDayInformation;
        this.loadingInformation = loadingInformation;
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
        String amPm, month, weekDay;
        Calendar calendar = Calendar.getInstance();
        TextView cityName = (TextView) this.weekDayInformation.findViewById(R.id.city);
        TextView dateAndTime = (TextView) this.weekDayInformation.findViewById(R.id.date);
        TextView weekDayView = (TextView) this.weatherInformation.findViewById(R.id.week_day_info);
        TextView temperatureView = (TextView) this.weatherInformation.findViewById(R.id.temperature);

        amPm = calendar.get(Calendar.AM_PM) == 0 ? "PM" : "AM";
        month = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US).toUpperCase();
        weekDay = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US) + " " + getDayPart();

        weekDayView.setText(weekDay.toUpperCase());

        if (!result.isEmpty()) {
            this.city = CityParser.parseCity(result);

            temperatureView.setText(this.city.getIntMaxTemperature() + "º / " + this.city.getIntMinTemperature() + "º");

            this.loadingInformation.setVisibility(View.GONE);
        }


        cityName.setText(city.getName().toUpperCase());
        dateAndTime.setText(calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + " " + amPm + " / " + calendar.get(Calendar.DAY_OF_MONTH) + " " + month);
        Log.i("WeatherData", result);
    }

    private String getDayPart() {
        String dayPart = null;
        Calendar calendar = Calendar.getInstance();
        int amPm = calendar.get(Calendar.AM_PM);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if (hour < 12 && amPm > 0)
            dayPart = "Morning";
        else if (hour > 0 && amPm < 1)
            dayPart = "Day";
        else
            dayPart = "Night";

        return dayPart;
    }
}

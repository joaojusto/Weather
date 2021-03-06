package com.groupbuddies.weather;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Weather extends Activity {
    private LinearLayout forecastTable = null;
    private RelativeLayout weatherInformation = null;
    private RelativeLayout weekDayInformation = null;
    private RelativeLayout loadingInformation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        forecastTable = (LinearLayout) findViewById(R.id.forecast_table);
        weatherInformation = (RelativeLayout) findViewById(R.id.main_content);
        loadingInformation = (RelativeLayout) findViewById(R.id.loading_information);
        weekDayInformation = (RelativeLayout) findViewById(R.id.city_date_information);

        WeatherData weatherData = new WeatherData(weatherInformation, weekDayInformation,
                loadingInformation, forecastTable);

        weatherData.execute(getResources().getString(R.string.api));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

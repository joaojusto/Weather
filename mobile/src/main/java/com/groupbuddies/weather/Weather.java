package com.groupbuddies.weather;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Weather extends Activity {
    private TextView weatherInformation = null;
    private TextView weekDayInformation = null;
    private RelativeLayout loadingInformation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        weatherInformation = (TextView) findViewById(R.id.loading_label);
        weekDayInformation = (TextView) findViewById(R.id.week_day_info);
        loadingInformation = (RelativeLayout) findViewById(R.id.loading_information);

        WeatherData weatherData = new WeatherData(weatherInformation, weekDayInformation, loadingInformation);

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

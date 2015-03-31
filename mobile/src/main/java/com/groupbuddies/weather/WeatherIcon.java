package com.groupbuddies.weather;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by joaojusto on 31/03/15.
 */
public class WeatherIcon extends TextView {
    private static HashMap<String, String> icons = new HashMap<>();

    public WeatherIcon(Context context) {
        super(context);

        this.populateIconMap();
        this.setCustomTypeface();
    }

    public WeatherIcon(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.populateIconMap();
        this.setCustomTypeface();
    }

    public WeatherIcon(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.populateIconMap();
        this.setCustomTypeface();
    }

    public WeatherIcon(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        this.populateIconMap();
        this.setCustomTypeface();
    }

    private void setCustomTypeface() {
        Typeface weatherTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/weatherIcons.ttf");

        setTypeface(weatherTypeface);
    }

    public void populateIconMap() {
        icons.put("01d", "");
        icons.put("02d", "");
        icons.put("03d", "");
        icons.put("04d", "");
        icons.put("10d", "");
        icons.put("09d", "");
        icons.put("11d", "");
        icons.put("13d", "");
        icons.put("50d", "");
    }

    public static String getIconCode(String weatherCondition) {
        return icons.get(weatherCondition);
    }
}

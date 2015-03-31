package com.groupbuddies.weather;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by joaojusto on 31/03/15.
 */
public class WeatherIcon extends TextView {
    public WeatherIcon(Context context) {
        super(context);

        this.setCustomTypeface();
    }

    public WeatherIcon(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.setCustomTypeface();
    }

    public WeatherIcon(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.setCustomTypeface();
    }

    public WeatherIcon(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        this.setCustomTypeface();
    }

    private void setCustomTypeface() {
        Typeface weatherTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/weatherIcons.ttf");

        setTypeface(weatherTypeface);
    }
}

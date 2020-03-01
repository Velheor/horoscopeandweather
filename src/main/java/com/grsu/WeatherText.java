package com.grsu;

import java.util.Random;

public enum WeatherText {
    GOOD("will be sunny."),
    BAD("will be rainy."),
    COLD("will be snow."),
    HOT("will be very hot."),
    WINDY("wind 30 km/h"),
    DAMP("damp weather");

    private static final WeatherText[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();
    private String weatherText;

    WeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public static WeatherText getRandomText() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }

    @Override
    public String toString() {
        return weatherText;
    }
}

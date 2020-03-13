package com.grsu.model.domain;

import com.grsu.io.InputOutput;

public class Horoscope implements Forecast {
    private String predict;
    private String period;
    private final int price = 1;

    public Horoscope(String predict, String period) {
        this.predict = predict;
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }

    public String getPredict() {
        return predict;
    }

    public int getPrice() {
        return price;
    }
}
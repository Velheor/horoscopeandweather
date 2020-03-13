package com.grsu.model.domain;

public class Weather extends Predict implements Forecast {
    private String predict;
    private String period;
    private final int price = 2;

    public Weather(String predict, String period) {
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
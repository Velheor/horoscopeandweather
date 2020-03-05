package com.grsu.model;

import java.util.HashMap;
import java.util.Map;

public class Forecast {
    private Period period = new Period();
    private Predict predict = new Predict();
    private Map<String, String> weatherPredicts = new HashMap<String, String>();

    public String createForecast(String predictType, String dateType) {
        String predict = this.predict.createPredict(predictType);
        String period = this.period.createPeriod(dateType);
        if (predictType.equals("2")) {
            predict = checkForUniqueWeatherPredict(period, predict);
        } else
            predict = this.predict.createPredict(predictType);
        return period + " " + predict;
    }

    public String checkForUniqueWeatherPredict(String period, String predict) {
        if (!weatherPredicts.containsKey(period)) {
            weatherPredicts.put(period, predict);
        }
        return weatherPredicts.get(period);
    }
}

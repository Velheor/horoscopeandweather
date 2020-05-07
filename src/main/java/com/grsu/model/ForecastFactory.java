package com.grsu.model;

import com.grsu.io.InputOutput;
import com.grsu.model.domain.*;

import java.util.ArrayList;
import java.util.List;

public class ForecastFactory {
    private List<Forecast> forecasts = new ArrayList<>();

    public Forecast createForecast(PredictType predictType, PeriodType periodType, InputOutput io) {
        Forecast forecast = null;
        Period period = new Period(io);
        Predict predict = new Predict();
        switch (predictType) {
            case WEATHER:
                forecast = new Weather(predict.createPredict("weather"), period.createPeriod(periodType));
                break;
            case HOROSCOPE:
                forecast = new Horoscope(predict.createPredict("horoscope"), period.createPeriod(periodType));
                break;
        }
        return checkForUniquePredict(forecast, forecast.getPeriod());
    }

    private Forecast checkForUniquePredict(Forecast forecast, String period) {
        if (forecasts.stream().noneMatch(o -> o.getPeriod().equals(period) && o instanceof Weather)) {
            forecasts.add(forecast);
        }
        return forecasts.stream().filter(o -> o.getPeriod().equals(period)).findFirst().get();
    }

    public String paidService() {
        return "Earned " + forecasts.stream().map(Forecast::getPrice).reduce(Integer::sum).orElse(0);
    }
}
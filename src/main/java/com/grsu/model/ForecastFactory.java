package com.grsu.model;

import com.grsu.io.InputOutput;
import com.grsu.model.domain.*;

import java.util.ArrayList;
import java.util.List;

public class ForecastFactory {
    private List<Forecast> forecasts = new ArrayList<>();

    public Forecast createForecast(PredictType predictType, PeriodType periodType, InputOutput io) {
        Forecast forecast = null;
        switch (predictType) {
            case WEATHER:
                forecast = new Weather(periodType, io);
                break;
            case HOROSCOPE:
                forecast = new Horoscope(periodType, io);
                break;
        }
        return checkForUniquePredict(forecast, forecast.getPeriod());
    }

    private Forecast checkForUniquePredict(Forecast forecast, String period) {
        if (!forecasts.stream().filter(o -> o.getPeriod().equals(period) && o instanceof Weather).findFirst().isPresent()) {
            forecasts.add(forecast);
        }
        return forecasts.stream().filter(o -> o.getPeriod().equals(period)).findFirst().get();
    }

    public String paidService() {
        return "Earned " + forecasts.stream().map(s -> s.getPrice()).reduce((s1, s2) -> s1 + s2).orElse(0);
    }
}
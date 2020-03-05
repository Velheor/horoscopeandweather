package com.grsu.model;

import com.grsu.model.domain.*;

import java.util.ArrayList;
import java.util.List;

public class ForecastFactory {
    private List<Forecast> forecasts = new ArrayList<>();

    public Forecast createForecast(PredictType predictType, PeriodType periodType) {
        Forecast forecast = null;
        switch (predictType) {
            case WEATHER:
                forecast = new Weather(periodType);
                forecast = checkForUniquePredict(forecast, forecast.getPeriod());
                break;
            case HOROSCOPE:
                forecast = new Horoscope(periodType);
                forecasts.add(forecast);
                break;
        }
        return forecast;
    }

    private Forecast checkForUniquePredict(Forecast forecast, String period) {
        if (!forecasts.stream().filter(o -> o.getPeriod().equals(period)).findFirst().isPresent()) {
            forecasts.add(forecast);
        }
        return forecasts.stream().filter(o -> o.getPeriod().equals(period)).findFirst().get();
    }

    public String paidService() {
        return "Earned " + forecasts.stream().map(s-> s.getPrice()).reduce((s1,s2)-> s1+s2).orElse(0);
    }
}
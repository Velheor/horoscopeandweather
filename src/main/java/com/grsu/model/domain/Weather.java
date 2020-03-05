package com.grsu.model.domain;

public class Weather extends Predict implements Forecast {
    private String predict;
    private String period;

    public Weather(PeriodType periodType){
        period = createPeriod(periodType);
        predict = createPredict("src/main/java/com/grsu/predictsText/Weather.txt");
    }

    public String getPeriod() {
        return period;
    }

    public String getPredict(){
        return predict;
    }
}

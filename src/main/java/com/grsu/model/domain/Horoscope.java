package com.grsu.model.domain;

public class Horoscope extends Predict implements Forecast {
    private String predict;
    private String period;

    public Horoscope(PeriodType periodType){
        period = createPeriod(periodType);
        predict = createPredict("src/main/java/com/grsu/predictsText/Horoscope.txt");
    }

    public String getPeriod() {
        return period;
    }

    public String getPredict(){
        return predict;
    }
}
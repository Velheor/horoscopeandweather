package com.grsu;

import com.grsu.io.IOConsole;
import com.grsu.io.InputOutput;
import com.grsu.model.ForecastFactory;
import com.grsu.model.domain.Forecast;
import com.grsu.model.domain.PeriodType;
import com.grsu.model.domain.PredictType;

public class Menu {
    private InputOutput inputOutput = new IOConsole();
    private ForecastFactory forecastFactory = new ForecastFactory();

    public static void main(String[] str) {
        Menu menu = new Menu();
        menu.mainMenu();
    }

    public void mainMenu() {
        Forecast forecast = null;
        inputOutput.writeMessage("Hello!");
        serviceType();
        String type = inputOutput.getAnswer();
        dateToPredictMenu();
        String date = inputOutput.getAnswer();
        switch (type) {
            case "1":
                forecast = forecastFactory.createForecast(PredictType.HOROSCOPE, periodType(date));
                break;
            case "2":
                forecast = forecastFactory.createForecast(PredictType.WEATHER, periodType(date));
                break;
            case "3":
                inputOutput.writeMessage(forecastFactory.paidService());
                mainMenu();
        }
        inputOutput.writeMessage(forecast.getPeriod() + " " + forecast.getPredict());
        mainMenu();
    }

    public void serviceType() {
        inputOutput.writeMessage("1 - horoscope costs 1$");
        inputOutput.writeMessage("2 - weather forecast costs 2$");
        inputOutput.writeMessage("3 - money earned");
    }

    public void dateToPredictMenu() {
        inputOutput.writeMessage("Choose date");
        inputOutput.writeMessage("1 - tomorrow");
        inputOutput.writeMessage("2 - week");
        inputOutput.writeMessage("3 - month");
        inputOutput.writeMessage("4 - special day");
    }

    public PeriodType periodType(String periodType) {
        PeriodType type = null;
        switch (periodType) {
            case "1":
                type = PeriodType.TOMMOROW;
                break;
            case "2":
                type = PeriodType.WEEK;
                break;
            case "3":
                type = PeriodType.MONTH;
                break;
            case "4":
                inputOutput.writeMessage("MM.dd.yyyy");
                type = PeriodType.SPECIALDAY;
                break;
        }
        return type;
    }
}
package com.grsu;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private InputOutput inputOutput = new IOConsole();
    private Period period = new Period();
    private Predict predict = new Predict();
    private Map<String, String> weatherPredicts = new HashMap<String, String>();

    public void mainMenu() {
        String periodForPredict = "";
        String predictForPeriod = "";
        inputOutput.writeMessage("Hello!");
        serviceType();
        String type = inputOutput.getAnswer();
        dateToPredictMenu();
        String date = inputOutput.getAnswer();
        if (date.equals("4")) {
            inputOutput.writeMessage("Enter date MM/DD/YEAR:");
            periodForPredict = period.predictForSpecialDate(inputOutput.getAnswer());
        } else {
            periodForPredict = period.createPeriod(date);
        }
        if (type.equals("2")) {
            predictForPeriod = checkForUniqueWeatherPredict(periodForPredict, predict.createPredict("2"));
        } else
            periodForPredict = predict.createPredict(type);
        inputOutput.writeMessage(periodForPredict + predictForPeriod);
        mainMenu();
    }

    public void serviceType() {
        inputOutput.writeMessage("1 - horoscope");
        inputOutput.writeMessage("2 - weather forecast");
    }

    public void dateToPredictMenu() {
        inputOutput.writeMessage("Choose date");
        inputOutput.writeMessage("1 - tomorrow");
        inputOutput.writeMessage("2 - week");
        inputOutput.writeMessage("3 - month");
        inputOutput.writeMessage("4 - special day");
    }

    public String checkForUniqueWeatherPredict(String period, String predict) {
        if (!weatherPredicts.containsKey(period)) {
            weatherPredicts.put(period, predict);
        }
        return weatherPredicts.get(period);
    }
}
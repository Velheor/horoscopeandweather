package com.grsu;

public class Menu {
    private InputOutput inputOutput = new IOConsole();
    private Forecast forecast = new Forecast();

    public void mainMenu() {
        inputOutput.writeMessage("Hello!");
        serviceType();
        String type = inputOutput.getAnswer();
        dateToPredictMenu();
        String date = inputOutput.getAnswer();
        if (date.equals("4")) {
            inputOutput.writeMessage("MM.dd.yyyy");
            date = inputOutput.getAnswer();
        }
        inputOutput.writeMessage(forecast.createForecast(type, date));
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


}
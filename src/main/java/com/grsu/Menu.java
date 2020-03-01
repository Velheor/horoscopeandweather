package com.grsu;

public class Menu {
    private InputOutput inputOutput = new IOConsole();

    public void mainMenu() {
        inputOutput.writeMessage("Hello!");
        inputOutput.writeMessage("1 - horoscope");
        inputOutput.writeMessage("2 - weather forecast");
        switch (inputOutput.getAnswer()) {
            case "1":
                inputOutput.writeMessage("Enter your birthday MM/DD/YEAR:");
                inputOutput.getAnswer();
                dateToPredictMenu();
                inputOutput.writeMessage(periodType(inputOutput.getAnswer()) + " " + HoroscopeText.getRandomText().toString());
                break;
            case "2":
                dateToPredictMenu();
                inputOutput.writeMessage(periodType(inputOutput.getAnswer()) + " " + WeatherText.getRandomText().toString());
                break;
        }
    }

    public String periodType(String answer) {
        Period period = new Period();
        switch (answer) {
            case "1":
                return period.predictForTomorrow();
            case "2":
                return period.predictForWeekend();
            case "3":
                return period.predictForMonth();
            case "4":
                inputOutput.writeMessage("Enter date MM/DD/YEAR:");
                return period.predictForSpecialDate(inputOutput.getAnswer());
            default:
                return "error";
        }
    }

    public void dateToPredictMenu() {
        inputOutput.writeMessage("Choose date");
        inputOutput.writeMessage("1 - tomorrow");
        inputOutput.writeMessage("2 - week");
        inputOutput.writeMessage("3 - month");
        inputOutput.writeMessage("4 - special day");
    }
}


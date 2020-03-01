package com.grsu;

public class Menu {
    private InputOutput inputOutput = new IOConsole();

    public void mainMenu() {
        inputOutput.writeMessage("Hello!");
        inputOutput.writeMessage("1 - horoscope");
        inputOutput.writeMessage("2 - weather forecast");
        inputOutput = new IOConsole();
        switch (inputOutput.getAnswer()) {
            case "1":
                inputOutput.writeMessage("Enter your birthday MM/DD/YEAR:");
                inputOutput.writeMessage("Choose type of horoscope:");
                inputOutput.getAnswer();
            case "2":
                inputOutput.writeMessage("Choose type of weather:");
            default:
                typeMenu();
        }
    }

    public void typeMenu() {
        Horoscope horoscope = new Horoscope();
        inputOutput.writeMessage("1 - tomorrow");
        inputOutput.writeMessage("2 - week");
        inputOutput.writeMessage("3 - month");
        inputOutput.writeMessage("4 - special day");
        inputOutput.writeMessage(horoscope.horoscopeType(inputOutput.getAnswer()));
    }
}


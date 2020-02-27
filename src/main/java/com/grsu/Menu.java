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
                horoscopeMenu();
                break;
            case "2":
                weatherMenu();
                break;
        }
    }

    public void horoscopeMenu() {
        Horoscope horoscope = new Horoscope();
        inputOutput.writeMessage("Enter your birthday MM/DD/YEAR:");
        inputOutput.getAnswer();
        inputOutput.writeMessage("Choose type of horoscope:");
        inputOutput.writeMessage("1 - tomorrow");
        inputOutput.writeMessage("2 - week");
        inputOutput.writeMessage("3 - month");
        inputOutput.writeMessage(horoscope.horoscopeType(inputOutput.getAnswer()));
    }

    public void weatherMenu() {
        inputOutput.writeMessage("Enter your birthday MM/DD/YEAR:");
        String date = inputOutput.getAnswer();
    }
}


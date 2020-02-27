package com.grsu;

public class Horoscope {
    public String horoscopeType(String answer) {
        switch (answer) {
            case "1":
                return horoscopeForTomorrow();
            case "2":
                return horoscopeForWeekend();
            case "3":
                return horoscopeForMonth();
        }
        return "";
    }

    private String horoscopeForMonth() {
        return "Tomorrow will be a good day";
    }

    private String horoscopeForWeekend() {
        return "Tomorrow will be a good day";
    }

    public String horoscopeForTomorrow() {
        return "Tomorrow will be a good day";
    }
}

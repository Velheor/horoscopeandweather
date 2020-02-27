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
            default:
                return "error";
        }
    }

    private String horoscopeForMonth() {
        return "";
    }

    private String horoscopeForWeekend() {
        return "Tomorrow will be a good day";
    }

    public String horoscopeForTomorrow() {
        HoroscopeText horoscopeText = HoroscopeText.valueOf("LOVE");
        return horoscopeText.toString();
    }
}

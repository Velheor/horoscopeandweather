package com.grsu;

import java.time.LocalDate;
import java.util.Calendar;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

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
        return "At " + LocalDate.now().getMonth().name() + " " + HoroscopeText.getRandomText().toString();
    }

    public String horoscopeForWeekend() {
        LocalDate today = LocalDate.now();
        LocalDate monday = today.with(previousOrSame(MONDAY));
        LocalDate sunday = today.with(nextOrSame(SUNDAY));
        return "From " + monday.toString() + " to " + sunday.toString() + " " + HoroscopeText.getRandomText().toString();
    }

    public String horoscopeForTomorrow() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return "Today " + calendar.getTime() + " " + HoroscopeText.getRandomText().toString();
    }


}

package com.grsu.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

public class Period {
    public String createPeriod(String answer) {
        String periods = "";
        switch (answer) {
            case "1":
                periods = predictForTomorrow();
                break;
            case "2":
                periods = predictForWeekend();
                break;
            case "3":
                periods = predictForMonth();
                break;
            default:
                periods = predictForSpecialDate(answer);
        }
        return periods;
    }

    private String parseDate(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
            return sdf.parse(date).toString();
        } catch (ParseException e) {
            return "Error";
        }
    }

    public String predictForSpecialDate(String day) {
        return "At " + parseDate(day);
    }

    public String predictForMonth() {
        return "At " + LocalDate.now().getMonth().name();
    }

    public String predictForWeekend() {
        LocalDate today = LocalDate.now();
        LocalDate monday = today.with(previousOrSame(MONDAY));
        LocalDate sunday = today.with(nextOrSame(SUNDAY));
        return "From " + monday.toString() + " to " + sunday.toString();
    }

    public String predictForTomorrow() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return "Today " + calendar.getTime();
    }
}

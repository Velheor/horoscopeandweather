package com.grsu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

public class Period {
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
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return "Today " + calendar.getTime();
    }
}

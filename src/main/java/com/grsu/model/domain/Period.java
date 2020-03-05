package com.grsu.model.domain;

import com.grsu.io.IOConsole;
import com.grsu.io.InputOutput;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

public abstract class Period {
    InputOutput inputOutput = new IOConsole();

    public String createPeriod(PeriodType type) {
        String period = new String();
        switch (type) {
            case TOMMOROW:
                period = predictForTomorrow();
                break;
            case WEEK:
                period = predictForWeekend();
                break;
            case MONTH:
                period = predictForMonth();
                break;
            case SPECIALDAY:
                period = predictForSpecialDate(inputOutput.getAnswer());
                break;
        }
        return period;
    }

    private String parseDate(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
            return sdf.parse(date).toString();
        } catch (ParseException e) {
            return "Error";
        }
    }

    private String predictForSpecialDate(String day) {
        return "At " + parseDate(day);
    }

    private String predictForMonth() {
        return "At " + LocalDate.now().getMonth().name();
    }

    private String predictForWeekend() {
        LocalDate today = LocalDate.now();
        LocalDate monday = today.with(previousOrSame(MONDAY));
        LocalDate sunday = today.with(nextOrSame(SUNDAY));
        return "From " + monday.toString() + " to " + sunday.toString();
    }

    private String predictForTomorrow() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return "Today " + calendar.getTime();
    }
}

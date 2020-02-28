package com.grsu;

import java.util.Random;

public enum HoroscopeText {
    MONEY("Be careful with money."),
    LOVE("Be open with your partner."),
    WORK("Do a lot at the job."),
    MOOD("Do not let broke day."),
    PLAN("Plan your weekends.");

    private String horoscopeText;
    private static final HoroscopeText[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    HoroscopeText(String horoscopeText) {
        this.horoscopeText = horoscopeText;
    }

    public static HoroscopeText getRandomText()  {
        HoroscopeText horoscopeText = VALUES[RANDOM.nextInt(SIZE)];
        return horoscopeText;
    }

    @Override
    public String toString() {
        return horoscopeText;
    }
}

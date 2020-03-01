package com.grsu;

import java.util.Random;

public enum HoroscopeText {
    MONEY("be careful with money."),
    LOVE("be open with your partner."),
    WORK("do a lot at the job."),
    MOOD("do not let broke day."),
    PLAN("plan your weekends.");

    private static final HoroscopeText[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();
    private String horoscopeText;

    HoroscopeText(String horoscopeText) {
        this.horoscopeText = horoscopeText;
    }

    public static HoroscopeText getRandomText()  {
        return VALUES[RANDOM.nextInt(SIZE)];
    }

    @Override
    public String toString() {
        return horoscopeText;
    }
}

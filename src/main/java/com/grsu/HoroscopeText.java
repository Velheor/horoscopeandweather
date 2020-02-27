package com.grsu;

public enum HoroscopeText {
    MONEY("Be careful with money."),
    LOVE("Be open with your partner."),
    WORK("Do a lot at the job."),
    MOOD("Do not let broke day."),
    PLAN("Plan your weekends.");

    private String horoscopeText;

    HoroscopeText(String horoscopeText) {
        this.horoscopeText = horoscopeText;
    }

    public String getHoroscopeText() {
        return horoscopeText;
    }

    @Override
    public String toString() {
        return horoscopeText;
    }
}

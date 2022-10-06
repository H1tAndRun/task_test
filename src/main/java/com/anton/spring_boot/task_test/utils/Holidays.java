package com.anton.spring_boot.task_test.utils;

public enum Holidays {

    NewYear("01-01"),
    DefendersOfDay("02-23"),
    Christmas("01-07"),
    laborDay("05-01"),
    WomenDay("03-08"),
    VictoryDay("05-09");
    private final String holidayDate;

    Holidays(String happy) {
        this.holidayDate = happy;
    }

    public String getHolidayDate() {
        return holidayDate;
    }
}

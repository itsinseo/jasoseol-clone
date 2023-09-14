package com.itsinseo.jasoseolclone.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeFormatter {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static String simpleTime(LocalDateTime localDateTime) {
        return dateTimeFormatter.format(localDateTime);
    }
}

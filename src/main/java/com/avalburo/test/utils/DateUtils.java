package com.avalburo.test.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private DateUtils() {

    }

    public static String getCurrentDateAsString(String pattern) {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
	LocalDateTime now = LocalDateTime.now();
	return now.format(formatter);
    }

}

package com.example.demo;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class LocalDateIsoFormatterTest {

    @Test
    public void testLocalDateFormatFromJson() {
        String value = "2014-05-27T12:30:05-07:00";
        assertEquals(value, ZonedDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME).toString());
    }
}

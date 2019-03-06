package com.example.demo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CustomZonedDateTimeDeserializer extends StdDeserializer<ZonedDateTime> {

    private static final long serialVersionUID = 1L;

    protected CustomZonedDateTimeDeserializer() {
        super(ZonedDateTime.class);
    }


    @Override
    public ZonedDateTime deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return ZonedDateTime.parse(jp.readValueAs(String.class), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
}

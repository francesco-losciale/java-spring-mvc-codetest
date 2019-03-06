package com.example.demo;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Customer {

    private Long id;
    private String name;
    @JsonDeserialize(using = CustomZonedDateTimeDeserializer.class)
    @JsonSerialize(using = CustomZonedDateTimeSerializer.class)
    private ZonedDateTime duetime;
    @JsonDeserialize(using = CustomZonedDateTimeDeserializer.class)
    @JsonSerialize(using = CustomZonedDateTimeSerializer.class)
    private ZonedDateTime jointime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getDuetime() {
        return duetime;
    }

    public void setDuetime(ZonedDateTime duetime) {
        this.duetime = duetime;
    }

    public ZonedDateTime getJointime() {
        return jointime;
    }

    public void setJointime(ZonedDateTime jointime) {
        this.jointime = jointime;
    }
}

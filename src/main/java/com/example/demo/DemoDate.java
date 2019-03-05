package com.example.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class DemoDate {

    private Long id;
    private String name;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeFormatter.ISO_OFFSET_DATE_TIME)
//    private LocalDate duetime;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//    private LocalDate jointime;
    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    @JsonSerialize(using = CustomLocalDateSerializer.class)
    private LocalDate duetime;
    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    @JsonSerialize(using = CustomLocalDateSerializer.class)
    private LocalDate jointime;

    public DemoDate() {

    }

    public DemoDate(Long id, String name, LocalDate duetime, LocalDate jointime) {
        this.id = id;
        this.name = name;
        this.duetime = duetime;
        this.jointime = jointime;
    }

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

    public LocalDate getDuetime() {
        return duetime;
    }

    public void setDuetime(LocalDate duetime) {
        this.duetime = duetime;
    }

    public LocalDate getJointime() {
        return jointime;
    }

    public void setJointime(LocalDate jointime) {
        this.jointime = jointime;
    }
}

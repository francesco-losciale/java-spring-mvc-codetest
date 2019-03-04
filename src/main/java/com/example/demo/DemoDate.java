package com.example.demo;

import java.time.LocalDate;

public class DemoDate {

    private Long id;
    private String name;
    private LocalDate dueTime;
    private LocalDate joinTime;

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

    public LocalDate getDueTime() {
        return dueTime;
    }

    public void setDueTime(LocalDate dueTime) {
        this.dueTime = dueTime;
    }

    public LocalDate getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(LocalDate joinTime) {
        this.joinTime = joinTime;
    }
}

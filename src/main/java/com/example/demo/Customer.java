package com.example.demo;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Customer implements Comparable<Customer> {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != null ? !id.equals(customer.id) : customer.id != null) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (duetime != null ? !duetime.equals(customer.duetime) : customer.duetime != null) return false;
        return jointime != null ? jointime.equals(customer.jointime) : customer.jointime == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (duetime != null ? duetime.hashCode() : 0);
        result = 31 * result + (jointime != null ? jointime.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Customer customer) {
        return this.duetime.compareTo(customer.duetime);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duetime=" + duetime +
                ", jointime=" + jointime +
                '}';
    }
}

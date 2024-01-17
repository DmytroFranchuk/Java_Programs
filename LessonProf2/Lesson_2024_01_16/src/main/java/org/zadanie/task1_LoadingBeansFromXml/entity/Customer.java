package org.zadanie.task1_LoadingBeansFromXml.entity;

import java.time.LocalDate;

public class Customer {
    private long id;
    private String name;
    private LocalDate dateOfLastNotification;
    private String phone;
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfLastNotification() {
        return dateOfLastNotification;
    }

    public void setDateOfLastNotification(LocalDate dateOfLastNotification) {
        this.dateOfLastNotification = dateOfLastNotification;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s { %s, %s, %s, %s, %s }",this.getClass().getSimpleName(), id, name, dateOfLastNotification, phone, email);
    }
}

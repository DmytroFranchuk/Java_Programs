package org.example.dto;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.beans.ConstructorProperties;
import java.time.LocalDate;
import java.util.Objects;

public class Friend {
    @Size(min = 2, max = 20, message = "Name length could be from 2 to 20 symbols")
    private final String name;

    @Size(min = 2, max = 20, message = "Name length could be from 2 to 20 symbols")
    private final String surname;

    @PastOrPresent(message = "Date of birth must be in the past")
    private final LocalDate dateOfBirth;

    @ConstructorProperties({"name", "surname", "dateOfBirth"})
    public Friend(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friend friend = (Friend) o;
        return Objects.equals(name, friend.name) && Objects.equals(surname, friend.surname) && Objects.equals(dateOfBirth, friend.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, dateOfBirth);
    }

    @Override
    public String toString() {
        return "\nFriend{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

package org.validation.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z]+")
    private String firstName;
    @NotBlank
    @Pattern(regexp = "[a-zA-Z]+")
    private String lastName;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z]+")
    private String department;

    @Min(0)
    @Max(10000)
    private int salary;

    @Pattern(regexp = "^200[1-9]|20[1-9]\\d-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$")
    private String hired;

    @Email
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getHired() {
        return hired;
    }

    public void setHired(String hired) {
        this.hired = hired;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", hired='" + hired + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

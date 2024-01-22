package com.example.demoBeanXml;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "students")
public class Student {
    @Id
    private Long id;
    private int age;
    private String email;
    private String name;
}
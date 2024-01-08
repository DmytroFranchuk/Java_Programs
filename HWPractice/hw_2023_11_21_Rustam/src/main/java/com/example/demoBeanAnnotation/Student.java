package com.example.demoBeanAnnotation;

import lombok.Data;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Data
public class Student {
    private Long id;
    private int age;
    private String email;
    private String name;
}

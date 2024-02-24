package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.user.User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "events")
    private Set<User> users=new HashSet<>();
}
//Предположим, бизнес проводит периодические вебинары по продвижению товаров. Создайте класс Event,
// хранящий информацию о событии, которое посетил пользователь (дата, название).
// Один пользователь может посетить многие события и одно событие могут посетить многие пользователи.
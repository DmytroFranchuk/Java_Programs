package org.lesson.springExample.task3_suitExample.entity.impl;

import org.lesson.springExample.task3_suitExample.entity.interfaces.Tie;
import org.springframework.stereotype.Component;

@Component
public class BowTie implements Tie {
    @Override
    public void tie() {
        System.out.println("Новая реализация галстука: бабочка");
    }
}

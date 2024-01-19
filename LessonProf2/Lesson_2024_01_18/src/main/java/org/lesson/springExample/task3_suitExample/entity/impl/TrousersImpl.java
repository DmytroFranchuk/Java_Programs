package org.lesson.springExample.task3_suitExample.entity.impl;

import org.lesson.springExample.task3_suitExample.entity.interfaces.Trousers;
import org.springframework.stereotype.Component;

@Component
public class TrousersImpl implements Trousers {
    @Override
    public void winkle() {
        System.out.println("Брюки помялись");
    }
}

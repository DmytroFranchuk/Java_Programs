package org.lesson.springExample.task3_suitExample.entity.impl;

import org.lesson.springExample.task3_suitExample.entity.interfaces.Jacket;
import org.springframework.stereotype.Component;

@Component
public class JacketImpl implements Jacket {
    @Override
    public void wearJacket() {
        System.out.println("Носим жакет");
    }
}

package org.lesson.springExample.task3_suitExample.entity.impl;

import org.lesson.springExample.task3_suitExample.entity.interfaces.Shirt;
import org.springframework.stereotype.Component;

@Component
public class ShirtImpl implements Shirt {
    @Override
    public void iron() {
        System.out.println("Гладим рубашку");
    }
}

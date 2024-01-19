package org.solution.task1.Impl;

import org.solution.task1.interfaces.Engine;
import org.springframework.stereotype.Component;

@Component("electricEngine")
public class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Electric engine started");
    }

    @Override
    public void stop() {
        System.out.println("Electric engine stopped");
    }
}

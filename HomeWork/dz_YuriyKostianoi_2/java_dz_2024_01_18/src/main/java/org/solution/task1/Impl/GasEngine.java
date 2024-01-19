package org.solution.task1.Impl;

import org.solution.task1.interfaces.Engine;
import org.springframework.stereotype.Component;

@Component("gasEngine")
public class GasEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Gas engine started");
    }

    @Override
    public void stop() {
        System.out.println("Gas engine stopped");
    }
}

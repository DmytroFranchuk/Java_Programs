package org.solution.task1.model;

import org.solution.task1.interfaces.Engine;
import org.solution.task1.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private Engine engine;

    @Autowired
    private EngineService engineService;

    public void initializeEngine(int distance) {
        this.engine = engineService.initializeEngine(distance);
    }

    public Engine getEngine() {
        return engine;
    }
}
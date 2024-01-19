package org.solution.task1.service;

import org.solution.task1.interfaces.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EngineService {
    @Autowired
    @Qualifier("gasEngine")
    private Engine gasEngine;

    @Autowired
    @Qualifier("electricEngine")
    private Engine electricEngine;

    private static final int DISTANCE_THRESHOLD = 200;

    public Engine initializeEngine(int distance) {
        return  (distance > DISTANCE_THRESHOLD) ? gasEngine : electricEngine;
    }
}

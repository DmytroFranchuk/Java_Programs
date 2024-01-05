package org.example.level1.task6;

import java.time.LocalDate;

public class Event {
    private LocalDate startEvent;
    private LocalDate endEvent;
    private String description;

    public Event(LocalDate startEvent, LocalDate endEvent, String description) {
        this.startEvent = startEvent;
        this.endEvent = endEvent;
        this.description = description;
    }

    public LocalDate getStartEvent() {
        return startEvent;
    }

    public LocalDate getEndEvent() {
        return endEvent;
    }

    public String getDescription() {
        return description;
    }
}

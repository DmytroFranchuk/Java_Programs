package org.example.level1.task6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalendarEvent {
    List<Event> events;

    public CalendarEvent() {
        this.events = new ArrayList<>();
    }

    public List<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public boolean isSlotOccupied(Event event) {
        boolean isOccupied = false;
        for (Event e : events) {
            if (event.getStartEvent().isAfter(e.getStartEvent()) && event.getEndEvent().isBefore(e.getEndEvent())){
                return isOccupied = true;
            }
        }
        return  isOccupied;
    }

    public void printEventsInAscendingOrder() {
        Collections.sort(events, (event1, event2) -> event1.getStartEvent().compareTo(event2.getStartEvent()));
        System.out.println("События в порядке возрастания начала:");
        for (Event event : events) {
            System.out.println("Начало: " + event.getStartEvent() +
                    ", Конец: " + event.getEndEvent() +
                    ", Описание: " + event.getDescription());
        }
    }

    public void sortEventsInDescendingOrder() {
        Collections.sort(events, (event1, event2) -> event2.getStartEvent().compareTo(event1.getStartEvent()));
        System.out.println("События в порядке убывания:");
        for (Event event : events) {
            System.out.println("Начало: " + event.getStartEvent() +
                    ", Конец: " + event.getEndEvent() +
                    ", Описание: " + event.getDescription());
        }
    }

}

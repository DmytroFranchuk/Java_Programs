package org.example.level1.task6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Event events1 = new Event(LocalDate.of(2024, 1,1),
                                  LocalDate.of(2024,1,7),
                                    "winter holidays");
        Event events2 = new Event(LocalDate.of(2024, 1,8),
                LocalDate.of(2024,3,1),
                "learning java");
        Event events3 = new Event(LocalDate.of(2023, 2,15),
                LocalDate.of(2024,4,1),
                "Tel-Ran studies");
        Event events4 = new Event(LocalDate.of(1975, 5,16),
                LocalDate.of(2022,2,22),
                "living in Ukraine");

        CalendarEvent calendarEvent = new CalendarEvent();
        calendarEvent.addEvent(events1);
        calendarEvent.addEvent(events2);
        calendarEvent.addEvent(events3);
        calendarEvent.addEvent(events4);
        calendarEvent.printEventsInAscendingOrder();
        calendarEvent.sortEventsInDescendingOrder();

        System.out.println("");
        //level 2 task
        Event events5 = new Event(LocalDate.of(2024, 2,1),
                LocalDate.of(2024,2,12),
                "learning java script");

        if (!calendarEvent.isSlotOccupied(events5)) {
            calendarEvent.addEvent(events5);
            System.out.println("New event add");
        }else {
            System.out.println(new ExceptionAddNewEvent("Slot occupied "));
        }

        Event events6 = new Event(LocalDate.of(2024, 5,1),
                LocalDate.of(2024,7,12),
                "summer holidays");

        if (!calendarEvent.isSlotOccupied(events6)) {
            calendarEvent.addEvent(events6);
            System.out.println("New event add");
        }else System.out.println(new ExceptionAddNewEvent("Slot occupied "));

        calendarEvent.printEventsInAscendingOrder();
        calendarEvent.sortEventsInDescendingOrder();
    }



}

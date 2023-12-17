package org.pr_2023_12_08.fileThread.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.pr_2023_12_08.fileThread.event.Event;
import org.pr_2023_12_08.fileThread.event.EventLevel;

import java.time.ZonedDateTime;
import java.util.Random;

public class EventGenerator {
    private static final Random RND = new Random();
    private EventGenerator() {}

    public static Event nextEvent() {
        return null;
//                new
//                Event(ZonedDateTime.now(), RandomStringUtils.randomAlphabetic())
    }

    private static EventLevel nextLevel() {
        return null;
//        return EventLevel.values()[
//                RND.nextInt(EventLevel.values().)]
    }
}

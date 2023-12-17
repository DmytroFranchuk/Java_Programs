package org.pr_2023_12_08.fileThread.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.pr_2023_12_08.fileThread.event.Event;
import org.pr_2023_12_08.fileThread.log.Logger;
import org.pr_2023_12_08.fileThread.util.ObjectMapperUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Reader implements Runnable{
    private final Logger logger;
    private final ObjectMapper mapper;

    private List<Event> massages;
    private int lastReadLineN;

    public Reader(Logger logger) {
        this.logger = logger;
        this.mapper = ObjectMapperUtil.getObjectMapper();
        this.massages = new ArrayList<>();
        this.lastReadLineN = 0;
    }

    private List<Event> readNew() {
        logger.startReading();
        int newLineCount = logger.getLieneCount() - lastReadLineN;
        System.out.printf("R %d начал читать %d строк из лога %n", Thread.currentThread().getId(), newLineCount);
        List<String> lastJsons = logger.readLastNLines(newLineCount);
        logger.endReading();
        System.out.printf("R %d прочитал из лога %d строк: %s%n", Thread.currentThread().getId(), lastJsons.size(), lastJsons);
        List<Event> lastEvents = toEventList(lastJsons);
        System.out.printf("R %d сконвертировал json в %d событий %n", Thread.currentThread().getId(), lastJsons.size());
    return lastEvents;
    }

    private List<Event> toEventList(List<String> jsons){
        return null;
//        return new ArrayList<>(
//                jsons.stream()
//                .map(js -> {
//                    try {
//                        return Optional.ofNullable(mapper.readValues(js, Event.class));
//                    } catch (JsonProcessingException e) {
//                    System.err.printf("Не могу конвертировать json в Event: %s%n%s%n", js, e.getMessage());
//                    return Optional.empty();
//                    }
//                })
//                .filter(Optional::isPresent)
//                .map(op -> (Event)((Optional<?>) op).get())
//                .sorted()
//                .toList());
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            massages =readNew();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

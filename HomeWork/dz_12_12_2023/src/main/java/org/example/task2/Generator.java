package org.example.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {
    private List<Integer> integerList;

    public Generator() {
        this.integerList = new ArrayList<>();
    }

    public List<Integer> generatorList(int count, int start, int end) {
        for (int i = 0; i < count; i++) {
            integerList.add(ThreadLocalRandom.current().nextInt(start, end));
        }
        return integerList;
    }
}

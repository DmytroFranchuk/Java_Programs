package org.ls_2023_12_12_concurrent.task1;

import lombok.Data;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Data
public class ParallelRandom {

    public List<Integer> generateNums(int count) {
        List<Integer> result = new CopyOnWriteArrayList<>();
        for (int i = count; i > 0; i -= 5_000) {
            int finalI = i;
            Thread thread = new Thread(() -> fillIn(result, finalI));
            thread.start();
            System.out.println(thread.getName() + " : " + finalI);
        }
//        while (result.size() < count) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
        return new ArrayList<>(result);
    }

    public Set<Integer> generateUniqueNums(List<Integer> list) {
        Set<Integer> result = new CopyOnWriteArraySet<>(list);
        return result.parallelStream()
                .sorted(Comparator.comparingInt(Integer::intValue))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static void fillIn(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.add(ThreadLocalRandom.current().nextInt(-1000, 1000));
//            ThreadLocalRandom.current().ints(count).forEach(el -> list.add(el));
        }
    }
}

package org.ls_2023_11_30_NPE_Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("One");
        list.add("One");
        Stream<String> listStream = list.stream();

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        Set<Integer> evens = numbers.stream().filter(e -> e%2 == 0).collect(Collectors.toSet());
        System.out.println(evens);
    }
}

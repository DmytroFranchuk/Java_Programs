package org.ls_2023_12_12_concurrent.example;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Main {
    public static void main(String[] args) {

        // Cоздание пустой потокобезопасной коллекции
        List<String> copyOnWriteList1 = new CopyOnWriteArrayList<>();

        // Cоздание потокобезопасной коллекции с данными list
        List<String> regularList = new ArrayList<>();
        regularList.add("Data 1");
        regularList.add("Data 2");
        regularList.add("Data 3");
        CopyOnWriteArrayList<String> copyOnWriteList2 = new CopyOnWriteArrayList<>(regularList);

        // Создание потокобезопасной коллекции с копированием данных
        Integer[] data = {1, 2, 3, 4, 5};
        CopyOnWriteArrayList<Integer> copyOnWriteList3 = new CopyOnWriteArrayList<>(data);
        // ============================================================================================

        // Этот конструктор создает пустой набор данных CopyOnWriteArraySet.
        CopyOnWriteArraySet<Integer> set1 = new CopyOnWriteArraySet<>();

        // Этот конструктор создает набор данных CopyOnWriteArraySet с элементами из коллекции coll.
        List<Integer> coll = new ArrayList<>();
        CopyOnWriteArraySet<Integer> set2 = new CopyOnWriteArraySet<>(coll);
        Set<Integer> set3 = new CopyOnWriteArraySet<>(coll);

        // ============================================================================================
        // Создание пустой коллекции с параметрами по умолчанию: capacity (16),
        // load factor (0.75), concurrencyLevel (16).
        ConcurrentHashMap<Integer, Integer> map1 = new ConcurrentHashMap<>();

        // Создание пустой коллекции с заданным initialCapacity, остальные параметры
        // (load factor и concurrencyLevel) остаются по умолчанию.
        int initialCapacity = 32;
        ConcurrentHashMap<Integer, Integer> map2 = new ConcurrentHashMap<>(initialCapacity);

        // Создание пустой коллекции с заданными initialCapacity и loadFactor,
        // а параметр concurrencyLevel остается по умолчанию.
        initialCapacity = 30;
        float loadFactor = 0.8f;
        ConcurrentHashMap<Integer, Integer> map3 = new ConcurrentHashMap<>(initialCapacity, loadFactor);

        // Создание пустой коллекции с заданными параметрами initialCapacity, loadFactor, и concurrencyLevel.
        initialCapacity = 35;
        loadFactor = 0.82f;
        int concurrencyLevel = 8;
        ConcurrentHashMap<Integer, Integer> map4 = new ConcurrentHashMap<>(initialCapacity, loadFactor, concurrencyLevel);

        // Создание новой потокобезопасной коллекции на основе существующего Map.
        Map<Integer, Integer> existingMap = new HashMap<>();
        ConcurrentHashMap<Integer, Integer> map5 = new ConcurrentHashMap<>(existingMap);
    }
}

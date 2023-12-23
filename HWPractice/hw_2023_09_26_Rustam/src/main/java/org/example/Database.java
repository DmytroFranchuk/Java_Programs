package org.example;

import java.util.HashMap;
import java.util.Map;

public class Database<K extends Number, V> {
    private Map<K, V> map;

    public Database() {
        this.map = new HashMap<>();
    }

    public void addData(K key, V value) {
        map.put(key, value);
    }

    public V getValue(K key) {
        return map.get(key);
    }
}

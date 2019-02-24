package io.github.matiaskotlik.huskiehack2019;

import java.util.*;

public class ComplimentStorage implements Storage<String> {

    Map<String, Deque<String>> complimentMap;

    public ComplimentStorage() {
        complimentMap = new HashMap<>();
    }

    @Override
    public String get(String key) {
        return complimentMap.get(key).pop();
    }

    @Override
    public boolean store(String key, String data) {
        Deque<String> compliments = complimentMap.get(key);
        if (compliments == null) {
            compliments = new ArrayDeque<>();
        }
        compliments.push(data);
        complimentMap.put(key, compliments);
        return false;
    }
}

package io.github.matiaskotlik.huskiehack2019;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ComplimentStorage implements Storage<String> {

	Map<String, Deque<String>> complimentMap;

	public ComplimentStorage() {
		complimentMap = new HashMap<>();
	}

	@Override
	public String get(String key) {
		Deque<String> deque = complimentMap.get(key);
		try {
			if (deque != null) {
				return deque.pop();
			}
		} catch (NoSuchElementException e) {}
		return pickDefaultMessage();
	}

	public String pickDefaultMessage() {
		return "FUCK YOU";
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

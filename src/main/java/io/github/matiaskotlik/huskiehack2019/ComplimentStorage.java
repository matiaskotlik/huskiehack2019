package io.github.matiaskotlik.huskiehack2019;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ComplimentStorage implements Storage<String> {

	private Map<String, Deque<String>> complimentMap;
	private ObjectMapper mapper;

	public ComplimentStorage() {
		mapper = new ObjectMapper();
		try {
			complimentMap = mapper.readValue(new File("docs/compliments.db"), new TypeReference<Map<String, Deque<String>>>() {});
		} catch (Exception e) {
			e.printStackTrace();
			complimentMap = new HashMap<>();
		}
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
		return "You're an amazing person!";
	}

	@Override
	public boolean store(String key, String data) {
		Deque<String> compliments = complimentMap.get(key);
		if (compliments == null) {
			compliments = new ArrayDeque<>();
		}
		compliments.push(data);
		complimentMap.put(key, compliments);
		save();
		return false;
	}

	public void save() {
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("docs/compliments.db"), complimentMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

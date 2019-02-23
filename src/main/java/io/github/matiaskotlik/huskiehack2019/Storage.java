package io.github.matiaskotlik.huskiehack2019;

public interface Storage<T> {
	T get(String key);
	boolean store(String key, T data);
}

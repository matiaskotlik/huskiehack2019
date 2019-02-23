package io.github.matiaskotlik.huskiehack2019;

import java.util.HashMap;

public class DefaultMap<K, V> extends HashMap<K, V> {
	protected SimpleGenerator<V> simpleGenerator;

	public DefaultMap(SimpleGenerator<V> simpleGenerator) {
		super();
		this.simpleGenerator = simpleGenerator;
	}

	@Override
	public V get(Object key) {
		return containsKey(key) ? super.get(key) : simpleGenerator.generate();
	}
}

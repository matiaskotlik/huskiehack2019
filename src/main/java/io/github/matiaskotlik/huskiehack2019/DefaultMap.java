package io.github.matiaskotlik.huskiehack2019;

import java.util.HashMap;

public class DefaultMap<K, V> extends HashMap<K, V> {
	protected SimpleGenerator<V> defaultValueGenerator;

	public DefaultMap(SimpleGenerator<V> defaultValueGenerator) {
		super();
		this.defaultValueGenerator = defaultValueGenerator;
	}

	@Override
	public V get(Object key) {
		if (!containsKey(key)) {
			put((K) key, defaultValueGenerator.generate());
		}
		return super.get(key);
	}
}

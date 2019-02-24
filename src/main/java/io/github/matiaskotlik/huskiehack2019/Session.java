package io.github.matiaskotlik.huskiehack2019;

public class Session {
	private String name;

	public Session() {
		this(null);
	}

	public Session(String name) {
		this.name = name;
	}

	public void reset() {
		this.name = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

package io.github.matiaskotlik.huskiehack2019;

public class Session {
	private boolean loggedIn;
	private String name;

	public Session() {
		this(false, null);
	}

	public Session(boolean loggedIn, String name) {
		this.loggedIn = loggedIn;
		this.name = name;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public String getName() {
		return name;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void setName(String name) {
		this.name = name;
	}
}

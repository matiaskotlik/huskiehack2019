package io.github.matiaskotlik.huskiehack2019;

public class Account {
	private String name;
	private String hashed;
	private String salt;

	public Account(String name, String hashed, String salt) {
		this.name = name;
		this.hashed = hashed;
		this.salt = salt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHashed() {
		return hashed;
	}

	public void setHashed(String hashed) {
		this.hashed = hashed;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
}

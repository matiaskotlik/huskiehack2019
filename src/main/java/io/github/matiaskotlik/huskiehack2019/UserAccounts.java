package io.github.matiaskotlik.huskiehack2019;

import java.util.HashMap;
import java.util.Map;

public class UserAccounts {
	private Map<String, Account> accounts;

	public UserAccounts() {
		accounts = new HashMap<>();
	}

	public boolean addAccount(Account account) {
		return accounts.put(account.getName(), account) != null;
	}

	public Account getAccount(String name) {
		return accounts.get(name);
	}

	public Map<String, Account> getAccounts() {
		return accounts;
	}
}

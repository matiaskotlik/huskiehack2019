package io.github.matiaskotlik.huskiehack2019;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UserAccounts {
	private Map<String, Account> accounts;
	private ObjectMapper mapper;

	public UserAccounts() {
		mapper = new ObjectMapper();
		try {
			accounts = mapper.readValue(new File("docs/useraccounts.db"), new TypeReference<Map<String, Account>>() {});
		} catch (Exception e) {
			e.printStackTrace();
			accounts = new HashMap<>();
		}
	}

	public boolean addAccount(Account account) {
		boolean ret = accounts.put(account.getName(), account) != null;
		save();
		return ret;
	}

	public void save() {
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("docs/useraccounts.db"),
					accounts);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Account getAccount(String name) {
		return accounts.get(name);
	}

	public Map<String, Account> getAccounts() {
		return accounts;
	}
}

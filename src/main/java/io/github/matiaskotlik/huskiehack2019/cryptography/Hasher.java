package io.github.matiaskotlik.huskiehack2019.cryptography;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.util.UUID;

public class Hasher {
	public Hasher() {}

	public String genSalt() {
		return UUID.randomUUID().toString();
	}

	public String hash(String plaintext, String salt) {
		return BCrypt.withDefaults().hashToString(12, (plaintext + salt).toCharArray());
	}

	public boolean verify(String plaintext, String hashed, String salt) {
		return BCrypt.verifyer().verify((plaintext + salt).toCharArray(), hashed).verified;
	}
}

package io.github.matiaskotlik.huskiehack2019;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Template {
	private String raw;
	private String surround = "%";

	public Template(File file) {
		raw = readFile(file);
	}

	public String readFile(File file) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			return "File not found.";
		}
		byte[] data = new byte[(int) file.length()];
		try {
			fis.read(data);
			fis.close();
			return new String(data, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.err.println("Failed to read from file: " + file.getName());
		}
		return "Failed to read from file";
	}

	public String getRaw() {
		return raw;
	}

	public Template(String raw) {
		this.raw = raw;
	}

	public String render(Map<String, String> vars) {
		String rendered = getRaw();
		for (Map.Entry<String, String> entry : vars.entrySet()) {
			rendered = rendered.replace(surround + entry.getKey() + surround,
					entry.getValue());
		}
		return rendered;
	}

	public String render() {
		return render(new HashMap<>());
	}
}

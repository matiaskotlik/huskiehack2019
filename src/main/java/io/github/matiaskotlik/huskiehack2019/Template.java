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

	public Template(File file) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		try {
			fis.read(data);
			fis.close();
			raw = new String(data, StandardCharsets.UTF_8);
			return;
		} catch (IOException e) {
			System.err.println("Failed to read from file: " + file.getName());
		}
		raw = "Failed to read from file";
	}

	public Template(String raw) {
		this.raw = raw;
	}

	public String render(Map<String, String> vars) {
		String rendered = raw;
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

package io.github.matiaskotlik.huskiehack2019;

public class SessionList {
	private DefaultMap<String, Session> map;

	public SessionList() {
		map = new DefaultMap<>(Session::new);
	}

	public Session getSession(String sessionId) {
		return map.get(sessionId);
	}
}

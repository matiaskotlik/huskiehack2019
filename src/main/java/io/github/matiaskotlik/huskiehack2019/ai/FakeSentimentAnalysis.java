package io.github.matiaskotlik.huskiehack2019.ai;

public class FakeSentimentAnalysis extends SentimentAnalysis {
	public FakeSentimentAnalysis() {}

	@Override
	public boolean sentiment(String text) {
		return text.toLowerCase().contains("good");
	}
}

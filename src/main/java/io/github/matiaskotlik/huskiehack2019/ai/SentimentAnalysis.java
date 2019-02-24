package io.github.matiaskotlik.huskiehack2019.ai;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import io.github.matiaskotlik.huskiehack2019.ai.Pipeline;

import java.util.List;

public class SentimentAnalysis {

	private SentimentAnalysis() {}

	public static boolean sentiment(String text) {
		StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

		CoreDocument coreDocument = new CoreDocument(text);

		stanfordCoreNLP.annotate(coreDocument);

		List<CoreSentence> sentences = coreDocument.sentences();

		for (CoreSentence sentence : sentences) {
			String sentiment = sentence.sentiment();
			if (!(sentiment.equals("Positive") || sentiment.equals("Very Positive"))) {
				return false;
			}
		}
		return true;
	}
}
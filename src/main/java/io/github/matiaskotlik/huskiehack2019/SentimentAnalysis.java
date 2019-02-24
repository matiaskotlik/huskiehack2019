package io.github.matiaskotlik.huskiehack2019;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import java.util.List;
// import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
// import edu.stanford.nlp.trees.Tree;

public class SentimentAnalysis {

    private SentimentAnalysis() {}

    public static void main(String[] args) {
        System.out.println(sentiment("You are amazing. I hate you."));
    }

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
            // System.out.println(sentiment + "\t" + sentence);
            // Tree tree = sentence.sentimentTree();
            // System.out.println(RNNCoreAnnotations.getPredictedClass(tree));
        }
        return true;
    }
}
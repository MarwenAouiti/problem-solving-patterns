package arrays.slidingWindowPattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordConcatenation {
    private static List<Integer> findWordConcatenation(String str, String[] words) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        for (String word : words)
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);

        List<Integer> resultIndices = new ArrayList<>();
        int wordsCount = words.length, wordLength = words[0].length();

        for (int i = 0; i < str.length() - wordsCount * wordLength; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int nextWordIndex = i + j * wordLength;
                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
                if (!wordFrequencyMap.containsKey(word)) break;

                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);

                if (wordsSeen.get(word) > wordFrequencyMap.getOrDefault(word, 0)) break;
                if (j + 1 == wordsCount) resultIndices.add(i);
            }
        }
        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(WordConcatenation.findWordConcatenation("catfoxcat", new String[]{"cat", "fox"}));
        System.out.println(WordConcatenation.findWordConcatenation("catcatfoxfox", new String[]{"cat", "fox"}));

    }
}

package arrays.slidingWindowPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Time complexity O(N)
 * Space Complexity O(1)
 */
public class ReplaceLetters {
    private static int longestSubstring(String s, int k) {
        int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
        Map<Character, Integer> letterFrequencyMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                char leftChar = s.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }


        return maxLength;
    }

    public static void main(String[] args) {
        int r1 = ReplaceLetters.longestSubstring("aabccbb", 2);
        System.out.println(r1);
        int r2 = ReplaceLetters.longestSubstring("abbcb", 1);
        System.out.println(r2);
        int r3 = ReplaceLetters.longestSubstring("abccde", 1);
        System.out.println(r3);

    }
}

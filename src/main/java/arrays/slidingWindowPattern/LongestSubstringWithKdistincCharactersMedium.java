package arrays.slidingWindowPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Time complexity O(N)
 * Space complexity O(K)
 */
public class LongestSubstringWithKdistincCharactersMedium {
    private static int findLongestSubstringWithDistinctKChars(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k)
            throw new IllegalArgumentException();

        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);

            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(LongestSubstringWithKdistincCharactersMedium.findLongestSubstringWithDistinctKChars("araaci", 2));
        System.out.println(LongestSubstringWithKdistincCharactersMedium.findLongestSubstringWithDistinctKChars("araaci", 1));
        System.out.println(LongestSubstringWithKdistincCharactersMedium.findLongestSubstringWithDistinctKChars("cbbebi", 3));
    }
}

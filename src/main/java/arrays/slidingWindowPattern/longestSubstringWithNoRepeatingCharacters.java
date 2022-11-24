package arrays.slidingWindowPattern;


import java.util.HashMap;

public class longestSubstringWithNoRepeatingCharacters {
    private static int findLongestSubstr(String s) {
        int maxLength = 0, windowStart = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            if (hashMap.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, hashMap.get(rightChar) + 1);
            }
            hashMap.put(rightChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int result_one = longestSubstringWithNoRepeatingCharacters.findLongestSubstr("aabccbb");
        System.out.println(result_one);

        int result_two = longestSubstringWithNoRepeatingCharacters.findLongestSubstr("abbbb");
        System.out.println(result_two);

        int result_three = longestSubstringWithNoRepeatingCharacters.findLongestSubstr("e");
        System.out.println(result_three);

    }
}

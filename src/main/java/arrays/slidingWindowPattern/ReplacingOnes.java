package arrays.slidingWindowPattern;

import java.util.HashMap;

/**
 * Time complexity O(N)
 * Space complexity O(1)
 */
public class ReplacingOnes {
    private static int findLength(int[] arr, int k) {
        int maxLength = 0, windowStart = 0;
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            int value = arr[windowEnd];
            frequency.put(value, frequency.getOrDefault(value, 0) + 1);

            if (frequency.get(0) == 2) {
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
                int startingValue = arr[windowStart];
                frequency.put(startingValue, frequency.get(startingValue) - 1);
                windowStart++;
            }
        }
        return maxLength + k;
    }

    public static void main(String[] args) {
        int result_one = ReplacingOnes.findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2);
        System.out.println(result_one);

        int result_two = ReplacingOnes.findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3);
        System.out.println(result_two);
    }
}

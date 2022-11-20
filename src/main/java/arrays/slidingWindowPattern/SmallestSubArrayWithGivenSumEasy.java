package arrays.slidingWindowPattern;

/**
 * Time Complexity O(N): for loop runs for all elements and  inner while loop processes each element only once
 * Space Complexity O(1)
 */
public class SmallestSubArrayWithGivenSumEasy {
    private static int findLengthOfSmallestContiguousSubarray(int S, int arr[]) {
        int smallestArrayLength = Integer.MAX_VALUE;
        int windowStart = 0;
        int windowSum = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            while (windowSum >= S) {
                smallestArrayLength = Math.min(smallestArrayLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return smallestArrayLength == Integer.MAX_VALUE ? 0 : smallestArrayLength;
    }

    public static void main(String[] args) {
        int result_one = SmallestSubArrayWithGivenSumEasy.findLengthOfSmallestContiguousSubarray(7, new int[]{2, 1, 5, 2, 3, 2});
        System.out.println("The smallest subarray with a sum great than or equal to " + result_one);

        int result_two = SmallestSubArrayWithGivenSumEasy.findLengthOfSmallestContiguousSubarray(7, new int[]{2, 1, 5, 2, 8});
        System.out.println("The smallest subarray with a sum great than or equal to " + result_two);

        int result_three = SmallestSubArrayWithGivenSumEasy.findLengthOfSmallestContiguousSubarray(8, new int[]{3, 4, 1, 1, 6});
        System.out.println("The smallest subarray with a sum great than or equal to " + result_three);
    }
}

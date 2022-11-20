package arrays.slidingWindowPattern;

/**
 * Time Complexity O(N), N the size of the array
 */
public class MaxSumOfSubarrayOfSizeKEasy {
    public static int findAverages(int K, int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int windowStart = 0;
        int windowSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            if (windowEnd >= K - 1) {
                if (windowSum > maxSum) maxSum = windowSum;
                windowSum = windowSum - arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int result_one = MaxSumOfSubarrayOfSizeKEasy.findAverages(3, new int[]{2, 1, 5, 1, 3, 2});
        System.out.println("maximum sum of any contiguous subarray of size K: " + (result_one));

        int result_two = MaxSumOfSubarrayOfSizeKEasy.findAverages(2, new int[]{2, 3, 4, 1, 5});
        System.out.println("maximum sum of any contiguous subarray of size K: " + (result_two));
    }
}

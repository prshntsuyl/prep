package practice.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * ZeroSum
 */
public class ZeroSum {

    /*
     * Given an array having both positive and negative integers. The task is to
     * compute the length of the largest subarray with sum 0.
     */
    public static void main(String[] args) {
        int N = 8;
        int[] A = { 15, -2, 2, -8, 1, 7, 10, 23 };

        System.out.println(maxLen(A, N));
        System.out.println(maxLenFailed(A, N));

    }

    static int maxLen(int[] arr, int n) {
        int[] prefix = new int[arr.length];

        int sum = 0;
        int max_length = 0;

        Map<Integer, Integer> hM = new HashMap<>();

        for (int i = 0; i < prefix.length; i++) {
            sum = sum + arr[i];

            // this initialised conditions are important
            if (arr[i] == 0 && max_length == 0)
                max_length = 1;

            if (sum == 0)
                max_length = i + 1;

            if (hM.containsKey(sum)) {
                max_length = Math.max(max_length, i - hM.get(sum));
            } else {
                hM.put(sum, i);
            }
        }

        return max_length;
    }

    // time limit not satisfied here
    static int maxLenFailed(int[] arr, int n) {
        // Your code here
        int maxSubSize = 0;
        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            int currentElement = arr[i];
            currentSum = currentSum + currentElement;

            for (int j = i + 1; j < arr.length; j++) {
                int nextElement = arr[j];
                currentSum = currentSum + nextElement;

                if (currentSum == 0 && (j - i + 1) > maxSubSize) {
                    maxSubSize = j - i + 1;
                }

            }
        }

        return maxSubSize;
    }
}

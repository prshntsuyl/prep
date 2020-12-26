package practice.array;

import java.util.HashMap;

class LargestSubarray {

  /*
   * 5. Largest subarray of 0's and 1's Easy Accuracy: 38.92% Submissions: 48242
   * Points: 2 Given an array of 0s and 1s. Find the length of the largest
   * subarray with equal number of 0s and 1s.
   *
   * Example 1:
   *
   * Input: N = 4 A[] = {0,1,0,1} Output: 4 Explanation: The array from index
   * [0...3] contains equal number of 0's and 1's. Thus maximum length of subarray
   * having equal number of 0's and 1's is 4. Example 2:
   *
   * Input: N = 5 A[] = {0,0,1,0,0} Output: 2 Your Task: You don't need to read
   * input or print anything. Your task is to complete the function maxLen() which
   * takes the array arr[] and the size of the array as inputs and returns the
   * length of the largest subarray with equal number of 0s and 1s.
   *
   * Expected Time Complexity: O(N). Expected Auxiliary Space: O(N).
   */
  public static void main(String[] args) {
    int size = 85;
    int[] arr = { 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1,
        0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0,
        1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 };

    System.out.println(maxLen(arr, size));

  }

  static int maxLen(int arr[], int n) {
    // Creates an empty hashMap hM

    HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

    // Initialize sum of elements
    int sum = 0;

    // Initialize result
    int max_len = 0;
    int ending_index = -1;
    int start_index = 0;

    for (int i = 0; i < n; i++) {
      arr[i] = (arr[i] == 0) ? -1 : 1;
    }

    // Traverse through the given array

    for (int i = 0; i < n; i++) {
      // Add current element to sum

      sum += arr[i];

      // To handle sum=0 at last index

      if (sum == 0) {
        max_len = i + 1;
        ending_index = i;
      }

      // If this sum is seen before,
      // then update max_len if required
      if (hM.containsKey(sum + n)) {
        if (max_len < i - hM.get(sum + n)) {
          max_len = i - hM.get(sum + n);
          ending_index = i;
        }
      } else // Else put this sum in hash table
        hM.put(sum + n, i);
    }

    for (int i = 0; i < n; i++) {
      arr[i] = (arr[i] == -1) ? 0 : 1;
    }

    int end = ending_index - (max_len - 1);
    System.out.println(end + " to " + ending_index);
  }
}

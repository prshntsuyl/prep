package practice.array;

class MissingNumber {

  /*
   * 1. Missing number in array Easy Accuracy: 42.51% Submissions: 16993 Points: 2
   * Given an array of size N-1 such that it can only contain distinct integers in
   * the range of 1 to N. Find the missing element.
   *
   * Example 1:
   *
   * Input: N = 5 A[] = {1,2,3,5} Output: 4 Example 2:
   *
   * Input: N = 10 A[] = {1,2,3,4,5,6,7,8,10} Output: 9 Your Task : Complete the
   * function MissingNumber() that takes array and N as input and returns the
   * value of the missing number.
   *
   * Expected Time Complexity: O(N). Expected Auxiliary Space: O(1).
   *
   * Constraints: 1 ≤ N ≤ 106 1 ≤ A[i] ≤ 106
   */
  public static void main(String[] args) {
    int N = 10;
    int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 10 };
    System.out.println("Hello World!");
    System.out.println(A[1]);

    System.out.println(findMissingNumber(A, N));
  }

  static int findMissingNumber(int[] arr, int size) {
    int totalSum = size * (size + 1) / 2;
    int initialSum = 0;
    for (int i = 0; i < size - 1; i++) {
      initialSum = arr[i] + initialSum;
    }

    return totalSum - initialSum;
  }

}

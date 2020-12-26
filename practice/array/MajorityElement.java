package practice.array;

import java.lang.Math;
import java.util.AbstractMap;

class MajorityElement {

  /*
   * 2. Majority Element Basic Accuracy: 48.6% Submissions: 22520 Points: 1 Given
   * an array A of N elements. Find the majority element in the array. A majority
   * element in an array A of size N is an element that appears more than N/2
   * times in the array.
   *
   * Example 1:
   *
   * Input: N = 3 A[] = {1,2,3} Output: -1
   *
   * Explanation: Since, each element in {1,2,3} appears only once so there is no
   * majority element. Example 2:
   *
   * Input: N = 5 A[] = {3,1,3,3,2} Output: 3 Explanation: Since, 3 is present
   * more than N/2 times, so it is the majority element. Your Task: The task is to
   * complete the function majorityElement() which returns the majority element in
   * the array. If no majority exists, return -1.
   *
   * Expected Time Complexity: O(N). Expected Auxiliary Space: O(1).
   */
  public static void main(String[] args) {
    int N = 2;
    int[] A = { 1, 3 };

    System.out.println(majorityElement(A, N));

  }

  static int majorityElement(int[] a, int size) {
    // your code here
    int cand = findCandidate(a, size);
    return isCandidateMajorityElement(a, size, cand);
  }

  // Moore's votin algorithm
  static int findCandidate(int[] a, int size) {
    int maj_index = 0;
    int count = 1;

    for (int i = 1; i < size; i++) {
      if (a[maj_index] == a[i])
        count++;
      else
        count--;

      if (count == 0) {
        maj_index = i;
        count = 1;
      }
    }

    return a[maj_index];
  }

  static int isCandidateMajorityElement(int a[], int size, int cand) {
    int i, count = 0;
    for (i = 0; i < size; i++) {
      if (a[i] == cand)
        count++;
    }
    if (count > size / 2)
      return cand;
    else
      return -1;
  }

  // static boolean isCandidateMajorityElement(int cand, int count, int size) {
  // double maj = size / 2;
  // maj = Math.ceil(maj);
  //
  // if (count > maj) {
  // return true;
  // }
  //
  // return false;
  // }

}

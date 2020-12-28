package practice.recursion;

import java.util.ArrayList;

class CombinationSum {

  /*
   *
   * Given an array of integers A[] of size N and a sum B, find all unique
   * combinations in A where the sum is equal to B. Each number in A may only be
   * used once in the combination Expected Time Complexity: O(2N) Expected
   * Auxiliary Space: O(2N)
   */
  public static void main(String[] args) {
    System.out.println("!!!");
    int[] abcd = { 2, 1, 4, 3, 6, 5 };
    System.out.println(combinationSum(abcd, 6, 6));
  }

  static ArrayList<ArrayList<Integer>> combinationSum(int[] A, int total, int sum) {
    // code here
  }
}

package practice.recursion;

class NumOfPaths {

  /*
   * The problem is to count all the possible paths from top left to bottom right
   * of a MxN matrix with the constraints that from each cell you can either move
   * to right or down.
   *
   * Expected Time Complexity: O(m + n - 1)) Expected Auxiliary Space: O(1)
   */

  public static void main(String[] args) {
    // System.out.println(numberOfPaths(3, 3));
    System.out.println(numberOfPathsUsingDP(3, 3));
  }

  static long numberOfPaths(int m, int n) {
    // Code Here
    if (m == 1 || n == 1) {
      return 1;
    }

    return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
    // return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1) + numberOfPaths(m -
    // 1, n - 1); // when diagonal movement is
    // allowed
  }

  // above solution is not optimal
  static long numberOfPathsUsingDP(int m, int n) {
    int[] dp = new int[n];
    dp[0] = 1;

    for (int i = 0; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[j] = dp[j] + dp[j - 1];
      }
    }

    return dp[n - 1];

  }

  // mathematical approach:: Note the count can also be calculated using the
  // formula (m-1 + n-1)!/(m-1)!(n-1)!.
}

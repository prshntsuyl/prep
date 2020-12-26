package practice.array;

import java.util.ArrayList;

class StockBuySell {

  public static void main(String[] args) {
    int N = 5;
    int[] A = { 4, 2, 2, 2, 4 };
    // System.out.println(stockBuySell(A, N));

    System.out.println(maxProfit(A));
  }

  static ArrayList<ArrayList<Integer>> stockBuySell(int[] A, int n) {
    // code here
    for (int i = 0; i < n; i++) {

    }
    return new ArrayList<>();
  }

  public static int maxProfit(int[] prices) {
    int n = prices.length;

    int cost = 0;
    int maxCost = 0;

    if (n == 0) {
      return 0;
    }

    // store the first element of array in a variable

    int min_price = prices[0];

    for (int i = 0; i < n; i++) {

      // now compare first element with all the
      // element of array and find the minimum element

      min_price = Math.min(min_price, prices[i]);

      // since min_price is smallest element of the
      // array so subtract with every element of the
      // array and return the maxCost

      cost = prices[i] - min_price;

      maxCost = Math.max(maxCost, cost);
    }
    return maxCost;
  }

  // Todo: Hint
  // Maximum difference in an array: Maintain max_diff and minimum element

}

package practice.dynamic;

import java.lang.Math;
import java.util.Map;
import java.util.HashMap;

public class Knapsack {

    /* W: capacity of knapsack (weight), N: total items (all has weight and values)
       wt: weights // val: values
       maximize the values
     */
    public static void main(String[] args) {
        //answer should be 6
        System.out.println(knapSack(4, new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 5, 4, 3}, 5));
        System.out.println(knapSackO(4, new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 5, 4, 3}, 5));
        System.out.println(knapSackBU(4, new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 5, 4, 3}, 5));

    }

    // das ist brute force
    static int knapSack(int W, int wt[], int val[], int n) {
        // your code here
        return knapSackLow(W, wt, val, 0);
    }

    static int knapSackLow(int W, int[] wt, int[] val, int i) {
        // your code here
        if (i == wt.length) {
            return 0;
        }

        if (W - wt[i] < 0) {
            return knapSackLow(W, wt, val, i + 1);
        }

        return Math.max(knapSackLow(W - wt[i], wt, val, i + 1) + val[i], knapSackLow(W, wt, val, i + 1));
    }

    // optimum
    static int knapSackO(int W, int wt[], int val[], int n) {
        // your code here
        Map<Integer, Map<Integer, Integer>> cache = new HashMap<Integer, Map<Integer, Integer>>();

        return knapSackCached(W, wt, val, 0, cache);
    }

    static int knapSackCached(int W, int[] wt, int[] val, int i, Map<Integer, Map<Integer, Integer>> cache) {
        if (i == wt.length) return 0;

        if (!cache.containsKey(i)) cache.put(i, new HashMap<Integer, Integer>());

        Integer cached = cache.get(i).get(W);

        if (cached != null) return cached;

        int toReturn;
        if (W - wt[i] < 0) {
            toReturn = knapSackCached(W, wt, val, i + 1, cache);
        } else {
            toReturn = Math.max(knapSackCached(W - wt[i], wt, val, i + 1, cache) + val[i], knapSackCached(W, wt, val, i + 1, cache));
        }

        cache.get(i).put(W, toReturn);
        return toReturn;
    }

    static int knapSackBU(int W, int wt[], int val[], int n) {
        int[][] cache = new int[wt.length + 1][W + 1];

        for (int i = 1; i <= wt.length; i++) {
            for (int j = 0; j <= W; j++) {
                if (wt[i - 1] > j) {
                    cache[i][j] = cache[i - 1][j];
                } else {
                    cache[i][j] = Math.max(cache[i - 1][j], cache[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }

        return cache[wt.length][W];
    }
}

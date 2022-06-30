import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//fewest number of coins that you need to make up that amount. 
class CoinChange {
    public static int coinChange(List<Integer> coins, int amount) {
        // WRITE YOUR BRILLIANT CODE HERE
        if (amount == 0) return 0;
        long[] dp = new long[amount+1];
        // Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                dp[i] = Math.min(dp[i],
                                 i >= coin ? dp[i - coin] + 1 : Integer.MAX_VALUE);
            }           
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];

    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? Collections.emptyList() : Arrays.asList(s.split(" "));
    }

    //1 2 5 -> 11
    //fewest coins used 5,5,1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> coins = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int amount = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = coinChange(coins, amount);
        System.out.println(res);
    }
}


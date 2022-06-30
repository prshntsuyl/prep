import java.util.Scanner;

//A robot is located at the top-left corner of a m x n grid.
class UniquePaths {
    public static int uniquePaths(int m, int n) {
        // WRITE YOUR BRILLIANT CODE HERE

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    System.out.println("dp[i][j-1]): " + dp[i][j-1]);
                    System.out.println("dp[i-1][j]:  " + dp[i-1][j]);
                    System.out.println();
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }

        return dp[n-1][m-1];
    }

    //3*2 metrics is below
    //3
    //2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = uniquePaths(m, n);
        System.out.println(res);
    }
}
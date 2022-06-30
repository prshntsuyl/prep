import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class MinimalPathSum {
    public static int minPathSum(List<List<Integer>> grid) {
        // WRITE YOUR BRILLIANT CODE HERE
        int rows = grid.size();
        int colums = grid.get(0).size();
        System.out.println("rows:: " + rows);
        System.out.println("colums:: " + colums);

        int[][] dp = new int[rows][colums];
        dp[0][0] = grid.get(0).get(0);

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                if (i == 0 && j > 0) {
                    // no op
                    int prev = dp[0][j-1];
                    int current = grid.get(0).get(j);
                    
                    dp[0][j] = current + prev;
                } else if (j == 0 && i > 0) {
                    int prev = dp[i-1][0];
                    int current = grid.get(i).get(0);
                    
                    dp[i][0] = prev + current;
                } else if (i > 0 && j > 0) {
                    int current = grid.get(i).get(j);

                    int left = dp[i][j-1] + current;
                    int right = dp[i-1][j] + current;

                    int result = Math.min(left, right);

                    dp[i][j] = result;
                }
            }
        }

        return dp[rows-1][colums-1];
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? Collections.emptyList() : Arrays.asList(s.split(" "));
    }

    // Input
    // 3
    // 1 3 1
    // 1 5 1
    // 4 2 1

    // Output:: 1 7

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gridLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < gridLength; i++) {
            grid.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        int res = minPathSum(grid);
        System.out.println(res);
    }
}
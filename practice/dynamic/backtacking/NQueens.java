package practice.dynamic.backtacking;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NQueens {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[][] tester = new int[N][N]; 

        System.out.println(nQueens(tester, N));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tester[i][j] + " ");
            }
            System.out.println();
        }

    }

    static boolean isAttacked(int x, int y, int[][] matrix) {
        int N = matrix[0].length;

        // before setting checking for pre-existing queens in row and column
        for (int k = 0; k < N; k++) {
            if ((matrix[x][k] == 1) || (matrix[k][y] == 1))
                return true;
        }

        //diagonal check
        for(int i : IntStream.range(0, N).boxed().collect(Collectors.toList())) {
            for(int j : IntStream.range(0, N).boxed().collect(Collectors.toList())) {
                boolean isCurrentElemet = (x == i && y == j);
                if (isCurrentElemet) {
                    continue;
                }
                if (matrix[i][j] == 1) {
                    if (i + j == x + y || i - j == x - y ) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    //backtracked recursion
    static boolean nQueens(int[][] matrix, int n) {
        if (n == 0) {
            return true;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                //is current position is in attack already ?
                if (isAttacked(i, j, matrix)) {
                    continue;
                }

                //not in attack therefore setting it
                matrix[i][j] = 1;
                //checking after placing for subproblems to set other queens
                if (nQueens(matrix, n - 1)) {
                    return true;
                }
                matrix[i][j] = 0;
            }
        }

        return false;

    }

}

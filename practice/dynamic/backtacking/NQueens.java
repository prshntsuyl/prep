package practice.dynamic.backtacking;

import java.util.Scanner;

public class NQueens {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.nextLine();

        prepareBoard(N);
    }

    static boolean isAttacked(int x, int y, int[][] matrix) {
        int[] row = matrix[x];

        for () {
        }
    }

    static void prepareBoard(String N) {
        int n = Integer.parseInt(N);
        int[][] matrix = new int[n][n];


        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }

        printAnswer(matrix);
    }

    static void printAnswer(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == matrix[0].length - 1) {
                    System.out.println(matrix[i][j]);
                } else {
                    System.out.print(matrix[i][j]);
                    System.out.print(" ");
                }
            }
        }

    }
}

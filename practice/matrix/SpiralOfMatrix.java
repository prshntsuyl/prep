package practice.matrix;

import java.util.ArrayList;
import java.util.List;

class SpiralOfMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];

        matrix[0][0] = 3;
        matrix[0][1] = 30;
        matrix[0][2] = 38;
        matrix[1][0] = 36;
        matrix[1][1] = 43;
        matrix[1][2] = 60;
        matrix[2][0] = 40;
        matrix[2][1] = 51;
        matrix[2][2] = 69;

        int R = 4;
        int C = 4;
        spirallyTraverse(matrix, R, C)
            .stream()
        	.map(ele -> ele + ",")
        	.forEach(System.out::print);
    }

    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
        // code here

        ArrayList<Integer> spiralList = new ArrayList<>();
        return spirallyTraverseImpl(matrix, 0, 0, 0, spiralList);
    }

    static ArrayList<Integer> spirallyTraverseImpl(int matrix[][], int x, int y, int k, ArrayList<Integer> spiralList) {
        if(spiralList.size() >= matrix.length * matrix[0].length) {
            return spiralList;
        } 

        for (int i = x; i < matrix[0].length - k; i++) {
            spiralList.add(matrix[x][i]);   
        }
        if(spiralList.size() >= matrix.length * matrix[0].length) {
            return spiralList;
        } 

        for (int i = y+1; i < matrix.length - k; i++) {
            spiralList.add(matrix[i][matrix[0].length - k - 1]);   
        }
        if(spiralList.size() >= matrix.length * matrix[0].length) {
            return spiralList;
        } 

        for (int i = matrix[0].length - k - 1 - 1; i >= k ; i--) {
            spiralList.add(matrix[matrix[0].length - k - 1][i]);   
        }
        if(spiralList.size() >= matrix.length * matrix[0].length) {
            return spiralList;
        } 

        for (int i = matrix.length - k - 1 - 1; i > k ; i--) {
            spiralList.add(matrix[i][y]);   
        }
        if(spiralList.size() >= matrix.length * matrix[0].length) {
            return spiralList;
        } 

        // return spiralList; 
        return spirallyTraverseImpl(matrix, x+1, y+1, k+1, spiralList);

    }
}
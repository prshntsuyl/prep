package practice.matrix;


class SearchInSOrtedMatrix {

    // n = 3, m = 3, x = 62
    // matrix[][] = {{ 3, 30, 38},
    //    	          {36, 43, 60},
    //        	      {40, 51, 69}}
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

        int n = 3;
        int m = 3;
        int x = 69;

        System.out.println(search(matrix, n, m, x));
    }

    static boolean search(int matrix[][], int n, int m, int x) {
        // code here
        return searchWithXY(matrix, 0, 0, x);
    }

    static boolean searchWithXY(int matrix[][], int x, int y, int k) {
        if(x > matrix.length - 1 || y > matrix[0].length - 1 ) {
            return false;
        }

        int currentElement = matrix[x][y];
        if (currentElement == k) {
            return true;
        }

        int lastBreadthElement = matrix[x][matrix[0].length - 1];
        int lastLengthElement = matrix[matrix.length - 1][y];

        if (k > currentElement && currentElement < lastBreadthElement) {
            for (int i = x; i < matrix[0].length; i++) {
                if (matrix[x][i] == k) {
                    return true;
                }
            }
        }
        if (k > currentElement && currentElement < lastLengthElement) {
            for (int i = y; i < matrix.length; i++) {
                if (matrix[i][y] == k) {
                    return true;
                }
            }
        }

        return searchWithXY(matrix, x + 1, y + 1, k);
    }

}
package practice.hashing;

import java.util.Arrays;

/**
 * RelativeSorting
 */
public class RelativeSorting {

    /*
     * Given two integer arrays. Sort the first array such that all the relative
     * positions of the elements in the first array are the same as the elements in
     * the second array. See example for better understanding Expected Time
     *
     * Complexity: O(NlogN). Expected Auxiliary Space: O(N)..
     */
    public static void main(String[] args) {
        int[] A1 = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
        int[] A2 = { 2, 1, 8, 3 };

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            if (i > 2) {
                System.out.println("contnue");
                continue;
            }
        }
        // sortA1ByA2(A1, 11, A2, 4);
        printArray(A1, 11);
    }

    public static void sortA1ByA2(int[] A1, int m, int[] A2, int n) {
        int[] tempArray = new int[m];
        int[] vistedArray = new int[m];

        // initialisation
        for (int i = 0; i < m; i++) {
            tempArray[i] = A1[i];
            vistedArray[i] = 0;
        }

        int ind = 0;
        Arrays.sort(tempArray);

        for (int i = 0; i < n; i++) {
            int f = first(tempArray, 0, m - 1, A2[i], m);
            if (f == -1) {
                continue;
            }

            for (int j = f; (j < m && tempArray[j] == A2[i]); j++) {
                A1[ind++] = tempArray[j];
                vistedArray[j] = 1;
            }

        }

        for (int i = 0; i < m; i++) {
            if (vistedArray[i] == 0) {
                A1[ind++] = tempArray[i];
            }
        }

    }

    // Utility function to print an array
    static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    /*
     * A Binary Search based function to find index of FIRST occurrence of x in
     * arr[]. If x is not present, then it returns -1
     */
    static int first(int[] arr, int low, int high, int x, int n) {
        if (high >= low) {
            /* (low + high)/2; */
            int mid = low + (high - low) / 2;

            if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
                return mid;
            if (x > arr[mid])
                return first(arr, (mid + 1), high, x, n);
            return first(arr, low, (mid - 1), x, n);
        }
        return -1;
    }
}

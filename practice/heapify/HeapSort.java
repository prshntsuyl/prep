package practice.heapify;

/**
 * HeapSort
 */
public class HeapSort {

    /*
     * Given an array of size N. The task is to sort the array elements by
     * completing functions heapify() and buildHeap() which are used to implement
     * Heap Sort.
     */
    public static void main(String[] args) {
        int N = 5;
        int[] arr = { 4, 1, 3, 9, 7 };

        System.out.println(heapify(arr, N));
    }

    void buildHeap(int arr[], int n) {
        // Your code here
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i) {
        // Your code here
    }
}

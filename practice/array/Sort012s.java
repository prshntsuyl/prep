package practice.array;

import java.util.ArrayList;
import java.util.List;

class Sort012s {

  // Given an array of size N containing only 0s, 1s, and 2s; sort the array in
  // ascending order.
  // sorts the array in-place
  public static void main(String[] args) {
    int N = 5;
    int[] arr = { 0, 2, 1, 2, 0 };
    sort012(arr, N);
  }

  public static void sort012(int[] a, int n) {
    // code here
    int countZero = 0;
    int countOne = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == 0) {
        countZero = countZero + 1;
      }
      if (a[i] == 1) {
        countOne = countOne + 1;
      }

    }

    for (int i = 0; i < countZero; i++) {
      a[i] = 0;
    }
    for (int i = countZero; i < countZero + countOne; i++) {
      a[i] = 1;
    }
    for (int i = countZero + countOne; i < n; i++) {
      a[i] = 2;
    }

  }
}

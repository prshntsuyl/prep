package practice.recursion;

class Keyboard {

  /*
   * Imagine you have a special keyboard with the following keys:
   *
   * Key 1: Prints 'A' on screen Key 2: (Ctrl-A): Select screen Key 3: (Ctrl-C):
   * Copy selection to buffer Key 4: (Ctrl-V): Print buffer on screen appending it
   * after what has already been printed.
   *
   * Find maximum numbers of A's that can be produced by pressing keys on the
   * special keyboard N times.
   *
   * Expected Time Complexity: O(N2) :: Expected Auxiliary Space: O(N)
   */
  public static void main(String[] args) {
    System.out.println(optimalKeys(7));
  }

  static int optimalKeys(int N) {
    // code here
    if (N == 1) {
      return 1;
    } else if (N == 2) {
      return 2;
    } else if (N == 3) {
      return 3;
    }

    return optimalKeys(N - 3) + optimalKeys(N - 4) + optimalKeys(N - 5);
  }
}

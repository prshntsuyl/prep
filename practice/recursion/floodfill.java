package practice.recursion;

class floodfill {
  // Dimentions of paint screen
  static int M = 8;
  static int N = 8;

  /*
   * Given a 2D screen, location of a pixel in the screen ie(x,y) and a color(K),
   * your task is to replace color of the given pixel and all adjacent(excluding
   * diagonally adjacent) same colored pixels with the given color K.
   */
  public static void main(String[] args) {

  }

  // Refer:
  // https://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/
  static void floodFillUtil(int screen[][], int x, int y, int prevC, int newC) {
    // Base cases
    if (x < 0 || x >= M || y < 0 || y >= N)
      return;
    if (screen[x][y] != prevC)
      return; // this behaves as breaking point

    // Replace the color at (x, y)
    screen[x][y] = newC;

    // Recur for north, east, south and west
    floodFillUtil(screen, x + 1, y, prevC, newC);
    floodFillUtil(screen, x - 1, y, prevC, newC);
    floodFillUtil(screen, x, y + 1, prevC, newC);
    floodFillUtil(screen, x, y - 1, prevC, newC);
  }
}

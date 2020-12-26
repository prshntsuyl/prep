package practice.array;

import java.util.LinkedHashSet;
import java.util.Scanner;

class LongestDistinctCharacter {

  /*
   * 4. Longest Distinct characters in string Easy Accuracy: 34.5% Submissions:
   * 52965 Points: 2 Given a string S, find length of the longest substring with
   * all distinct characters. For example, for input "abca", the output is 3 as
   * "abc" is the longest substring with all distinct characters.
   *
   * Input: The first line of input contains an integer T denoting the number of
   * test cases. The first line of each test case is String str.
   *
   * Output: Print length of smallest substring with maximum number of distinct
   * characters. Note: The output substring should have all distinct characters.
   *
   * Constraints: 1 ≤ T ≤ 100 1 ≤ size of str ≤ 10000
   *
   * Example: Input: 2 abababcdefababcdab geeksforgeeks
   *
   * Output: 6 7
   */
  public static void main(String[] args) {
    // String test = "abababcdefababcdab"; // 6
    // String test2 = "geeksforgeeks"; // 7
    // System.out.println(checkLongest("aldshflasghdfasgfkhgasdfasdgvfyweofyewyrtyefgv"));
    System.out.println(checkLongest("aldshflasghdfasgfkhgasdfasdgvfyweofyewyrtyefgv"));
    // 10

    // System.out.println(checkLongest(test2));
  }

  // public static void main(String[] args) {
  // Scanner s = new Scanner(System.in);
  // int numTest = Integer.parseInt(s.next());
  //
  // for (int i = 1; i <= numTest; i++) {
  // System.out.println(checkLongest(s.next())); // 4
  // }
  // }

  static int checkLongest(String str) {
    char[] chars = str.toCharArray();
    int count = 0;
    LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>();

    // for (int i = 0; i < chars.length; i++) { //mistake
    for (int i = 0; i < chars.length; i++) {
      // System.out.println(i);
      if (linkedHashSet.contains(chars[i])) {
        if (count < linkedHashSet.size()) {
          count = linkedHashSet.size();
          System.out.println(linkedHashSet);
        }
        linkedHashSet = new LinkedHashSet<>();
        i--;
        i--;
      } else {
        linkedHashSet.add(chars[i]);
      }
    }

    return count;
  }
}

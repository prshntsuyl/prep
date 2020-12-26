package practice.array;

import java.util.LinkedHashSet;

class RemoveDuplicates {
  /*
   * Given a string without spaces, the task is to remove duplicates from it.
   *
   * Note: The original order of characters must be kept the same.
   *
   * Example 1:
   *
   * Input: S = "geeksforGeeks" Output: geksfor Explanation: Only keep the first
   * occurrence Example 2:
   *
   * Input: S = "gfg" Output: gf Explanation: Only keep the first occurrence Your
   * task: Your task is to complete the function removeDups() which takes a single
   * string as input and returns the string. You need not take any input or print
   * anything.
   *
   *
   * Expected Time Complexity: O(|s|) Expected Auxiliary Space: O(constant)
   *
   * Constraints: 1 <= |S| <= 105 S conatins lowercase english alphabets
   */
  public static void main(String[] args) {
    System.out.println(removeDups("geeksforGeeks"));
  }

  static String removeDups(String str) {
    LinkedHashSet<Character> lhs = new LinkedHashSet<>();
    for (int i = 0; i < str.length(); i++) {
      lhs.add(str.charAt(i));
    }
    // print string after deleting duplicate elements
    StringBuilder stringBuilder = new StringBuilder();
    for (Character ch : lhs) {
      stringBuilder.append(ch);
    }

    return stringBuilder.toString();

  }
}

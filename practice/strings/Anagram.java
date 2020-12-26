package practice.array;

import java.util.Arrays;

class Anagram {
  public static void main(String[] args) {
    // inefficient
    System.out.println(isAnagram("cat", "tac"));
    // O(nlogn)
    System.out.println(AreAnagram("cat".toCharArray(), "act".toCharArray()));
    // // Testcase
    // String someString = "some";
    // char[] someChars = someString.toCharArray();
    // int count = 123;
    // System.out.println(someString.charAt(1) + count);
  }

  static boolean isAnagram(String a, String b) {

    if (a.length() != b.length()) {
      return false;
    }

    for (int i = 0; i < b.length(); i++) {
      String ch = b.charAt(i) + "";
      if (!a.contains(ch)) {
        return false;
      }

      a.replaceFirst(ch, "");

    }

    return true;
  }

  // Method 1 (Use Sorting)
  //
  // 1. Sort both strings
  // 2. Compare the sorted strings
  // Complexity O(nlogn)
  static boolean AreAnagram(char[] str1, char[] str2) {
    // Get lenghts of both strings
    int n1 = str1.length;
    int n2 = str2.length;

    // If length of both strings is not same,
    // then they cannot be anagram
    if (n1 != n2)
      return false;

    // Sort both strings
    Arrays.sort(str1);
    Arrays.sort(str2);

    // Compare sorted strings
    for (int i = 0; i < n1; i++)
      if (str1[i] != str2[i])
        return false;

    return true;
  }

  // O(n+n) ~ O(n) //Auxillary O(1)
  static boolean isAnagramWithOrderN(String c, String d) {
    if (c.length() != d.length())
      return false;

    int count = 0;

    // Take sum of all characters of
    // first String
    for (int i = 0; i < c.length(); i++) {
      count = count + c.charAt(i);
    }

    // Subtract the Value of all the characters
    // of second String
    for (int i = 0; i < d.length(); i++) {
      count = count - d.charAt(i);
    }

    // If Count = 0 then they are anagram
    // If count > 0 or count < 0 then
    // they are not anagram
    return (count == 0);
  }
}

package practice.array;

class Anagram {
  public static void main(String[] args) {
          System.out.println(isAnagram("cat", "tac"));
  }

  static boolean isAnagram(String a, String b) {

          if(a.length() != b.length()) {
                  return false;
          }

          for (int i=0; i < b.length(); i++) {
                  String ch = b.charAt(i) + "";
                  if(!a.contains(ch)) {
                          return false;
                  }

                  a.replaceFirst(ch, "");

          }

          return true;
  }
}

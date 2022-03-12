package practice.strings;

import java.util.HashMap;
import java.util.Scanner;

class Isomorphic {
    public static boolean isIsomorphic(String str1, String str2) {
        // WRITE YOUR BRILLIANT CODE HERE
        System.out.println("Start!!");

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        if (chars1.length != chars2.length) {
            return false;
        }

        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();

        for (char c : chars1) {
            if (hashMap1.get(c) != null) {
                hashMap1.put(c, hashMap1.get(c) + 1);
            } else {
                hashMap1.put(c, 1);
            }
        }

        for (char c : chars2) {
            if (hashMap2.get(c) != null) {
                hashMap2.put(c, hashMap2.get(c) + 1);
            } else {
                hashMap2.put(c, 1);
            }
        }

        if(hashMap1.size() != hashMap2.size()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();
        boolean res = isIsomorphic(str1, str2);
        System.out.println(res);
    }
}

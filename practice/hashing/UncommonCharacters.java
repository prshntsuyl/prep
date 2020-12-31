package practice.hashing;

import java.util.HashMap;
import java.util.Map;
import java.lang.StringBuilder;

/**
 * UncommonCharacters
 */
public class UncommonCharacters {

    /*
     * Given two strings A and B. Find the characters that are not common in the two
     * strings.
     */
    public static void main(String[] args) {
        String A = "geeksforgeeks";
        String B = "geeksquiz";

        System.out.println(UncommonChars(A, B));
    }

    static String UncommonChars(String A, String B) {
        // code here
        int[] presets = new int[26];

        for (int i = 0; i < presets.length; i++) {
            presets[i] = 0;
        }

        char[] firstStringChars = A.toCharArray();
        char[] secondStringChars = B.toCharArray();

        for (int i = 0; i < firstStringChars.length; i++) {
            presets[firstStringChars[i] - 'a'] = 1;
        }

        for (int i = 0; i < secondStringChars.length; i++) {
            int ind = secondStringChars[i] - 'a';
            if (presets[ind] == 1 || presets[ind] == -1) {
                presets[ind] = -1;
            } else {
                presets[ind] = 2;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < presets.length; i++) {
            if (presets[i] == 1 || presets[i] == 2) {
                stringBuilder.append((char) (i + 'a'));
            }
        }

        if (stringBuilder.length() == 0) {
            return "-1";
        }

        return stringBuilder.toString();
    }

    // bad approach

    // for (int i = 0; i < firstStringChars.length; i++) {
    // hM.put(firstStringChars[i], false);
    // }

    // for (int i = 0; i < secondStringChars.length; i++) {
    // if (hM.containsKey(secondStringChars[i])) {
    // hM.put(secondStringChars[i], true);
    // } else {
    // hM.put(secondStringChars[i], false);
    // }
    // }
}

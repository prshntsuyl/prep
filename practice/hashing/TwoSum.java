package practice.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class TwoSum {

    /*
    Given an array of positive integers and an integer. Determine whether or not there exist two elements in A whose sum is exactly equal to that integer.
    */
    public static void main(String[] args) {
        int[] A = new int[] {1, 2, 5, 6, 7};
        int N = 5;
        int X = 4;

        // int[] A = new int[] {335, 501, 170, 725, 479, 359, 963, 465, 706, 146, 282, 828, 962, 492, 996, 943, 828, 437, 392, 605, 903, 154, 293, 383, 422, 717, 719, 896, 448, 727, 772, 539, 870, 913, 668, 300, 36, 895, 704, 812, 323, 334};

        // int N = 42;
        // int X = 468;

        System.out.println(keypair(A, N, X));
    }

    static boolean keypair(int[] A, int N, int X) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i=0; i<N; i++) {
            int temp = X - A[i];

            if (hashSet.contains(temp)) {
                return true;    
            }

            hashSet.add(A[i]); 
        }

        return false;
    }

    static boolean keypair_wrong(int[] A, int N, int X) {
        // code here
        Map<Integer, Integer> hashMap = new HashMap<>();

        //prepare hashMap
        for (int i = 0; i < N; i++) {
            hashMap.put(X - A[i], A[i]);
        }

        //search for other sum
        Set<Integer> keys = hashMap.keySet();
        for (Integer key : keys) {
            if (hashMap.containsValue(key) && key != hashMap.get(key)) {
                System.out.println(key);

                return true;
            }
        }

        return false;
    }
}
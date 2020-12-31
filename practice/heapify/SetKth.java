package practice.heapify;

/**
 * SetKth
 */
public class SetKth {

    public static void main(String[] args) {
        int N = 278;
        int K = 7;
        System.out.println(setKthBit(N, K));
        System.out.println(setKthBitOptimal(N, K));
    }

    static int setKthBitOptimal(int N, int K) {
        return (1 << K) | N;
    }

    static int setKthBit(int N, int K) {
        char[] bitString = Integer.toBinaryString(N).toCharArray();
        int avail = Integer.parseInt(String.valueOf(bitString[bitString.length - K - 1]));

        if (avail == 0) {
            return N + (int) Math.pow(2, K);
        }

        return N;
    }
}

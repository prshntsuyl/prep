package templates.cheatsheet;

import java.math.BigInteger;
import java.util.*;

public class CheatSheet {

    // https://introcs.cs.princeton.edu/java/11cheatsheet/
    public static void main(String[] args) {
        mathLib();
        arrayInit();

        int a = 10;
        System.out.println(isOdd(a));
        multiplyAndDivideByTwo(9);
        swapTwoNumber();
        readInput();
        findNumberOfDigits();
        findGcd();
        isPrime();
        applySort();
    }

    private static void applySort() {
        int[] avc = {234, 234, 123, 1231};
        Arrays.sort(avc);
        System.out.println(avc[0]);

        List<Integer> integers = Arrays.asList(123, 231, 324, 63, 655, 655, 655);
        Comparator<Integer> someComparator = new SomeComparator();
        integers.sort(someComparator);

        System.out.println("Comparator is:: " + integers.get(1));

        System.out.println(Arrays.binarySearch(avc, 123));
        System.out.println("Frequency:: " + Collections.frequency(integers, 655));
    }

    private static void isPrime() {
        System.out.println("isPrime: " + BigInteger.valueOf(229).isProbablePrime(1));
    }

    private static void findGcd() {
        BigInteger bigInteger = BigInteger.valueOf(30);
        BigInteger bigInteger2 = BigInteger.valueOf(45);

        BigInteger gcd = bigInteger.gcd(bigInteger2);
        System.out.println("gcd" + gcd);
    }

    private static void findNumberOfDigits() {
        int d = 1234567;
        double v = Math.floor(Math.log10(d)) + 1;
        System.out.println(v);
    }

    private static void readInput() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String s2 = scanner.nextLine();

        System.out.println(s + s2);
    }

    private static void swapTwoNumber() {
        int a = 4;
        int b = 8;

        a ^= b;
        b ^= a;
        a ^= b;

        System.out.println("After swapping!!!");
        System.out.println(a);
        System.out.println(b);
    }

    private static void multiplyAndDivideByTwo(int i) {
        System.out.print("Divided by two: ");
        System.out.println(i >> 1);

        System.out.print("Multiply by two: ");
        System.out.println(i << 1);

        //System.out.println(9/2); -- 4
    }

    private static boolean isOdd(int a) {
        return (a & 1) == 1;
    }

    private static void arrayInit() {
        int[] abcd = {1, 2, 3, 4, 6};
        int[][] abcd2 = {{1, 2, 3, 4, 6}, {1, 2, 3, 4, 6}};
        System.out.println(abcd[1]);
        System.out.println(abcd2[1][2]);
    }

    private static void mathLib() {
        System.out.println(Math.exp(1));
        System.out.println(Math.log(10));
        System.out.println(Math.pow(1, 100));
        System.out.println(Math.pow(2, 5));
        System.out.println(Math.round(2.99));
        System.out.println(Math.round(2.5));
        System.out.println(Math.random());
    }
}

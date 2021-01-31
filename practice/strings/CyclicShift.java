package practice.strings;

import java.util.Scanner;

public class CyclicShift {

    private static int max = 0;
    private static int index = 0;
    private static int[] maxArray;
    private static int[] valArray;

    //  1
//  5 2
//  10101
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numOfCases = scanner.nextLine();
        int numberOfCases = Integer.parseInt(numOfCases);
        for (int i = 0; i < numberOfCases; i++)
            perform(scanner);

    }

    private static void perform(Scanner scanner) {
        String[] s = scanner.nextLine().split(" ");
        String input = scanner.nextLine(); //"010101";

        int thirdTime = Integer.parseInt(s[1]); // 4;
        int size = input.length();

        maxArray = new int[size];
        valArray = new int[size];
        for (int i = 1; i <= size; i++) {
            Integer integer = rotateAndGetValue(input, i);

            if (integer.toString().length() < input.length()) {
                input = "0" + integer.toString();
            } else {
                input = integer.toString();
            }
        }

        for (int i = 1; i <= size; i++) {
            if (valArray[i - 1] >= max) {
                maxArray[i - 1] = 1;
            } else {
                maxArray[i - 1] = 0;
            }

        }

//        System.out.println("max is::" + max);
//        System.out.println("shift are::" + index);

        int k = 0;
        int count = 0;
        int shifts = 0;
        int result = 0;
        while (k >= 0) {
            int isOne = maxArray[k];
            if (isOne == 1) {
                count++;
            }

            if (count == thirdTime) {
                result = shifts + 1;

                break;
            }

            k++;
            shifts++;
            k = k % size;
        }

//        System.out.println("second time is:: " + result);
        System.out.println(result);
    }

    private static Integer rotateAndGetValue(String input, int id) {
        //System.out.println(input);

        int i = Integer.parseInt(input, 2);
        int x = i << 1;
        String x1 = Integer.toBinaryString(x);
        //System.out.println("x1:: " + x1);
        String first = x1;
        String second = String.valueOf(input.charAt(0));
        if (x1.length() > input.length()) {
            first = x1.substring(1);
        }
        //System.out.println(first);

        int val = Integer.parseInt(first, 2) | Integer.parseInt(second, 2);

        if (val >= max) {
            max = val;
            index = id;
            valArray[id - 1] = val;
        } else {
            valArray[id - 1] = val;
        }

        return Integer.parseInt(first) | Integer.parseInt(second);
    }

    static int findTheNum(String input) {
        char first = input.charAt(0);
        int firstInt = Integer.parseInt(String.valueOf(first));

        int i = Integer.parseInt(input, 2);
        String x = Integer.toBinaryString(i << 1) + "0";
        //System.out.println(x);
        //System.out.println(Integer.toBinaryString(firstInt));
        return Integer.parseInt(x) | firstInt;
    }


}

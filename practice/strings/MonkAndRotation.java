package practice.strings;

import java.util.Scanner;

public class MonkAndRotation {

    /**
     * 1
     * 5 2
     * 1 2 3 4 5
     */
    public static void main(String args[]) throws Exception {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        String numOfCases = scanner.nextLine();
        int numberOfCases = Integer.parseInt(numOfCases);
        for (int i = 0; i < numberOfCases; i++)
            printRotateInitial(scanner);
    }

    static void printRotateInitial(Scanner scanner) {
        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();

        String[] splits = firstLine.split(" ");
        int N = Integer.parseInt(splits[0]);
        int K = Integer.parseInt(splits[1]);

        String[] elements = secondLine.split(" ");
        String[] another = new String[N];

        for (int i = 0; i < N; i++) {
            another[(i + K) % N] = elements[i];
        }

        System.out.print(another[0]);
        for (int i = 1; i < N; i++) {
            System.out.print(" " + another[i]);
        }
        System.out.println();

    }

    static void printRotated(String input, int N, int K) {
        String[] elements = input.split(" ");

        K = K % N;
        int startIndex = 0;
        if (K != 0) {
            startIndex = N - K;
        }
//        int startIndex = Math.abs(N-K) % N;

        System.out.print(elements[startIndex]);
        for (int i = 1; i < N; i++) {
            int index = startIndex + i;
            if (index >= N) {
                index = index - N;
            }

            System.out.print(" " + elements[index]);
        }
    }

    /**
     * Optimal Solution
     */
/*
    k=k%n;
    for i from 1 to N:
        b[(i+k)%n]=a[i];
    for i from 1 to N:
        print b[i];
*/

}

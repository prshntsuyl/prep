package practice.basics;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ReadingInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Provide Input here:: ");
        String inputReceived = scanner.nextLine();

        System.out.println("Processing Starts!!");
        System.out.println(inputReceived);

        char[] chars = inputReceived.toCharArray();

        IntStream range = IntStream.range(0, 10);
        range.forEach(a -> countOccurrence(chars, a));

    }

    static void countOccurrence(char[] chars, Integer i) {
        int count = 0;
        for(char c: chars) {
            if (Integer.parseInt(String.valueOf(c)) == i) {
                count++;
            }
        }

        System.out.println(i + " " + count);
    }
}

package practice.basics;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SetBitsCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numOfInputs = scanner.nextLine();
        List<String> inputs = IntStream.range(0, Integer.parseInt(numOfInputs))
                .mapToObj(ignore -> scanner.nextLine())
                .collect(Collectors.toList());

        inputs.stream()
                .forEach(SetBitsCount::betterApproach);
    }

    static void printsetBitCount(String input) {
        int num = Integer.parseInt(input);
        String binaryRep = Integer.toBinaryString(num);

        char[] chars = binaryRep.toCharArray();

        int count = 0;
        for (char c : chars) {
            if (c == '1') {
                count++;
            }
        }
        System.out.println(count);
    }

    static void betterApproach(String input) {
        int n = Integer.parseInt(input);
        int count = 0;

        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        System.out.println(count);
    }
}

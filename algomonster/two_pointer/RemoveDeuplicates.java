import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class RemoveDuplicates {

    // input:0 0 1 1 1 2 2
    // output 0 1 2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        int res = removeDuplicates(arr);
        System.out.println(arr.stream().limit(res).map(String::valueOf).collect(Collectors.joining(" ")));
    }

    public static int removeDuplicates(List<Integer> arr) {
        // WRITE YOUR BRILLIANT CODE HERE
        int leftPointer = 0;
        int rightPointer = 0;

        int slowVal = arr.get(leftPointer);
        int fastVal = arr.get(rightPointer);

        while (rightPointer < arr.size() - 1) {
            while ((fastVal == slowVal) && (rightPointer < (arr.size() - 1))) {
                rightPointer++;
                fastVal = arr.get(rightPointer);
            }
            leftPointer++;
            arr.set(leftPointer, fastVal);
            slowVal = fastVal;
        }

        return leftPointer;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? Collections.emptyList() : Arrays.asList(s.split(" "));
    }

}
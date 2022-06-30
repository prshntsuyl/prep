import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class BinarySearch {

    // find the element that equals to the target and return its index.
    public static List<String> splitWords(String s) {
        return s.isEmpty() ? Collections.emptyList() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        // int res = binarySearch(arr, target);
        int res = binarySearchGetIndex(arr, target);
        System.out.println(res);
    }

    public static int binarySearchGetIndex(List<Integer> arr, int target) {
        int leftPointer = 0;
        int rightPointer = arr.size() - 1;

        while (leftPointer <= rightPointer) {
            int midPointer = leftPointer + (rightPointer - leftPointer) / 2;

            if(arr.get(midPointer) == target) return midPointer;
            if(arr.get(midPointer) < target) {
                leftPointer = midPointer + 1;
            } else {
                rightPointer = midPointer - 1;
            }
        }

        return 0;

    }

    // used single pointer but this doesnt get you the index, this just tells if
    // element exists
    // to get index we need to use two pointers: left and right
    public static int binarySearch(List<Integer> arr, int target) {
        // WRITE YOUR BRILLIANT CODE HERE
        int midPointer;
        if (arr.size() % 2 != 0) {
            midPointer = arr.size() / 2;
        } else {
            midPointer = (arr.size() / 2) - 1;
        }

        if (arr.get(midPointer) >= target) {
            if (arr.get(midPointer) == target) {
                return midPointer;
            }
            return binarySearch(arr.subList(0, midPointer + 1), target);
        } else {
            return binarySearch(arr.subList(midPointer + 1, arr.size()), target);
        }
    }
}
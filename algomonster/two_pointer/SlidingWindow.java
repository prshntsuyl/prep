import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
    public static List<Integer> slidingWindowMaximum(List<Integer> nums, int k) {
        // WRITE YOUR BRILLIANT CODE HERE
        List<Integer> result = new ArrayList<>();
        ArrayDeque<Integer> adQ = new ArrayDeque<>();
        Iterator<Integer> iterator = nums.iterator();
        
        int count=0;
        while(count < k) {
            Integer next = iterator.next();
            if(adQ.size() == 0 || adQ.peek() < next) {
                adQ.poll();
                adQ.add(next);
            } else if (adQ.peek() > next && adQ.size() < 2) {
                adQ.add(next);
            }
            count++;
        }

        result.add(adQ.peek());

        while(iterator.hasNext()) {
            Integer next = iterator.next();
            if(adQ.peek() < next) {
                adQ.poll();
                adQ.poll();

                adQ.add(next);
            } else if (adQ.peek() > next && adQ.size() < 2) {
                adQ.add(next);
            } else if (adQ.peek() > next && adQ.size() == 2) {
                adQ.add(next);
                // adQ.poll();
                // if (adQ.peek() < next) {
                //     adQ.poll();
                // }
                // adQ.add(next);
            }
            
            result.add(adQ.peek());
        }        

        
        return result;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? Collections.emptyList() : Arrays.asList(s.split(" "));
    }

    // 1 3 2 5 8 7
    // 3
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int k = Integer.parseInt(scanner.nextLine());
        scanner.close();
        List<Integer> res = slidingWindowMaximum(nums, k);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}


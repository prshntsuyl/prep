import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

class KthLargest {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static int findKthLargest(List<Integer> nums, int k) {
        // WRITE YOUR BRILLIANT CODE HERE\
        Iterator<Integer> iterator = nums.iterator();
        while (pq.size() < k) {
            pq.add(iterator.next());
        }

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (pq.peek() <= next) {
                pq.poll();
                pq.add(next);
            }
        }
        return pq.peek();
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? Collections.emptyList() : Arrays.asList(s.split(" "));
    }

    // 3 2 1 5 6 4
    // 2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt)
                .collect(Collectors.toList());
        int k = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = findKthLargest(nums, k);
        System.out.println(res);
    }
}

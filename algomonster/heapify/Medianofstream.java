import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Medianofstream {

    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

    // 6
    // 1
    // 2
    // 3
    // get
    // 4
    // get
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numInputs = Integer.parseInt(scanner.nextLine());
        Medianofstream medianOfStream = new Medianofstream();
        for (int i = 0; i < numInputs; ++i) {
            String input = scanner.nextLine();
            if (input.equals("get")) {
                System.out.println(medianOfStream.getMedian());
            } else {
                medianOfStream.addNum(Integer.parseInt(input));
            }
        }
    }

    public void addNumMin(int num) {
        // WRITE YOUR BRILLIANT CODE HERE
        min.add(num);
    }

    public double getMin() {
        // ALSO HERE
        return min.poll();
    }

    public void addNum(int num) {
        // WRITE YOUR BRILLIANT CODE HERE
        if (min.size() == 0 || num < min.peek()) {
            max.add(num);
        } else {
            min.add(num);
        }

        balanceMinMaxPQs();
    }

    private void balanceMinMaxPQs() {
        if (min.size() > max.size()) {
            max.add(min.poll());
        } else if (max.size() > min.size() + 1) {
            min.add(max.poll());
        }
    }

    public double getMedian() {
        // ALSO HERE
        int minSize = min.size();
        int maxSize = max.size();

        if (minSize == maxSize) {
            return (min.peek() + max.peek()) / 2;
        } else {
            return max.peek();
        }

    }

}

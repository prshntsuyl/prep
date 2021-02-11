package practice.heapify;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Scratch {

    static PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(10, new MaxComparator());
    static PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>(10, new MinComparator());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numberOfScenarios = scanner.nextLine();
        int i = Integer.parseInt(numberOfScenarios);

        while (i > 0) {
            String currentLine = scanner.nextLine();
            System.out.println(currentLine);

            System.out.println(getMedian(Integer.parseInt(currentLine)));
            i--;
        }

        System.out.println("Max heap numbers!!!");
        while (!maxPriorityQueue.isEmpty()) {
            System.out.println(maxPriorityQueue.poll());
        }

        System.out.println("Min heap numbers!!!");
        while (!minPriorityQueue.isEmpty()) {
            System.out.println(minPriorityQueue.poll());
        }

    }

    public static double getMedian(int input) {
        if (maxPriorityQueue.isEmpty() || maxPriorityQueue.peek() > input) {
            maxPriorityQueue.offer(input);
        } else {
            minPriorityQueue.offer(input);
        }

        int maxSize = maxPriorityQueue.size();
        int minSize = minPriorityQueue.size();

        if (Math.abs(maxSize - minSize) > 1) {
            if (minSize > maxSize) {
                Integer poll = minPriorityQueue.poll();
                maxPriorityQueue.offer(poll);
            } else {
                Integer poll = maxPriorityQueue.poll();
                minPriorityQueue.offer(poll);
            }
        }

        int newMaxSize = maxPriorityQueue.size();
        int newMinSize = minPriorityQueue.size();

        if (newMinSize > newMaxSize) {
            return minPriorityQueue.peek();
        } else if (newMinSize < newMaxSize) {
            return maxPriorityQueue.peek();
        } else {
            Integer max = maxPriorityQueue.peek();
            Integer min = minPriorityQueue.peek();

            return (double) (max + min) / 2;
        }

    }

    public static class MinComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2) {
                return 1;
            }
            if (o1.equals(o2)) {
                return 0;
            }

            return -1;
        }

    }

    public static class MaxComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2) {
                return 1;
            }
            if (o1.equals(o2)) {
                return 0;
            }

            return -1;
        }

    }

    public static void main2(String[] args) {
        PriorityQueue<Integer> mmax = new PriorityQueue<>(5, new MaxComparator());
        PriorityQueue<Integer> mmin = new PriorityQueue<>(5, new MinComparator());
        mmax.offer(1);
        mmax.offer(2);
        mmax.offer(3);
        mmax.offer(3);
        mmax.offer(4);
        mmax.offer(5);

        mmin.offer(1);
        mmin.offer(2);
        mmin.offer(2);
        mmin.offer(3);
        mmin.offer(4);
        mmin.offer(5);

        System.out.println("Mmax:: ");
        while (!mmax.isEmpty()) {
            System.out.println(mmax.poll());
        }

        System.out.println("Mmin:: ");
        while (!mmin.isEmpty()) {
            System.out.println(mmin.poll());
        }
    }

}
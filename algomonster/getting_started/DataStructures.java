package algomonster.getting_started;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class DataStructures {

    public static void main(String[] args) {
        stackUsingArray();
        queue();

    }

    private static void queue() {
        // Initialize a new deque
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        // Add 2 to the end of the deque
        queue.add(2);
        // Add 4 to the front of the deque
        queue.addFirst(4);
        // Look at the front of the deque and print it
        System.out.println(queue.peek());
        // Look at the end of the deque and print it
        System.out.println(queue.peekLast());
        // Remove the front of the deque
        queue.poll();
        // Remove the end of the deque
        queue.pollLast();
    }

    private static void stackUsingArray() {
        // Initializes the stack
        ArrayList<Integer> stack = new ArrayList<>();
        // Pushing 5 into the stack
        stack.add(5);
        // Look at the top item of the stack and print it
        System.out.println(stack.get(stack.size() - 1));
        // Removing the top item from the stack
        stack.remove(stack.size() - 1);
    }
}

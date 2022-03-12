package algomonster.getting_started;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class DataStructures {

    // Array
    String[] clothes;
    int[] numbers;

    public static void main(String[] args) {
        stackUsingArray();
        queue();
        hashmap();
        array();
        arrayList();

    }

    private static void arrayList() {
        int[] numbers = {20, 6, 13, 5};
        // simple for loop goes through indices so we fetch elements using indices
        for (int i = 0; i < numbers.length; i++) {
           int number = numbers[i];
           System.out.println(number);
        }
        
        // for-each loop directly fetches elements
        for (int number : numbers) {
           System.out.println(number);
        }
    }

    private static void array() {
        arrayList();
    }

    private static void hashmap() {
        // Initialize a new hash map
        HashMap<String, Integer> hashmap = new HashMap<>();
        // Set the entry represented by "John" to 28
        hashmap.put("John", 28);
        // Check if "John" is in the hash map
        if (hashmap.containsKey("John")) {
            // Print the entry represented by "John"
            System.out.println(hashmap.get("John"));
        }
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

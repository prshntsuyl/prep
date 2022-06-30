import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//In the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
class LRUCache {
    public static List<Integer> exec(List<List<String>> operations) {
        // WRITE YOUR BRILLIANT CODE HERE

        List<String> definition = operations.get(0);
        Integer lruSize = Integer.valueOf(definition.get(1));

        HashMap<Integer, CompositeValue> lru = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        CompositeValue tail = null;
        CompositeValue head = null;

        for (int i = 1; i < operations.size(); i++) {
            List<String> operation = operations.get(i);

            if (operation.get(0) == "get") {
                getOperation(operation.get(1), result, lru, head, tail);
            } else if (operation.get(0) == "put") {
                putOperation(operation.get(1), operation.get(2), result, lru, head, tail);
            }

        }

        return result;
    }

    private static void getOperation(String string, ArrayList<Integer> result,
            HashMap<Integer, LRUCache.CompositeValue> lru, LRUCache.CompositeValue head, LRUCache.CompositeValue tail) {
        Integer key = Integer.valueOf(string);

        if (!lru.containsKey(key)) {
            result.add(-1);
        }

    }

    private static void putOperation(String string, String string2, ArrayList<Integer> result,
            HashMap<Integer, LRUCache.CompositeValue> lru, LRUCache.CompositeValue head, LRUCache.CompositeValue tail) {
        Integer key = Integer.valueOf(string);
        Integer value = Integer.valueOf(string2);

        if (lru.size() == 0) {
            CompositeValue compValue = new CompositeValue(key, value, null, null);
            lru.put(key, compValue);
            head = compValue;
            tail = compValue;
        } else {
            LRUCache.CompositeValue compositeValue = lru.get(key);
            int right = compositeValue.next;
            int left = compositeValue.prev;

            if (lru.containsKey(key)) {
                
                lru.put(key, compositeValue);
                tail = new CompositeValue(key, value, tail.key, null);
            } else {
                compositeValue.prev = null;
                lru.put(key, value, );
            }
        }


    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? Collections.emptyList() : Arrays.asList(s.split(" "));
    }

    static class CompositeValue {

        int key;
        int value;
        Integer next;
        Integer prev;

        CompositeValue(int key, int value, Integer next, Integer prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }

    // 10
    // LRUCache 2
    // put 1 1
    // put 2 2
    // get 1
    // put 3 3
    // get 2
    // put 4 4
    // get 1
    // get 3
    // get 4
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operationsLength = Integer.parseInt(scanner.nextLine());
        List<List<String>> operations = new ArrayList<>();
        for (int i = 0; i < operationsLength; i++) {
            operations.add(splitWords(scanner.nextLine()));
        }
        scanner.close();
        List<Integer> res = exec(operations);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
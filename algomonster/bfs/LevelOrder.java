import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

class LevelOrder {
    public static void main(String[] args) {
        System.out.println("hello world!!!");
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        List<List<Integer>> res = levelOrderTraversal(root);
        for (List<Integer> row : res) {
            System.out.println(row.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ")));
        }
    }

    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x"))
            return null;
        Node<T> left = buildTree(iter, f);
        Node<T> right = buildTree(iter, f);
        return new Node<T>(f.apply(val), left, right);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? Collections.emptyList() : Arrays.asList(s.split(" "));
    }

    public static List<List<Integer>> levelOrderTraversal(Node<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(root); // at least one element in the queue to kick start bfs
        while (queue.size() > 0) { // as long as there is element in the queue
            int n = queue.size();
            List<Integer> newLevel = new ArrayList<>();
            // dequeue each node in the current level
            for (int i = 0; i < n; i++) {
                Node<Integer> node = queue.pop();
                newLevel.add(node.value);
                // enqueue non-null children
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.add(newLevel);
        }

        return result;
    }

    static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        Node(T val) {
            this.value = val;
        }

        public Node(T val, Node<T> left, Node<T> right) {
            this.value = val;
            this.left = left;
            this.right = right;
        }

    }
}
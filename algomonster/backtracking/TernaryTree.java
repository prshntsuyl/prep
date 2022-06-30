import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class TernaryTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        List<String> res = ternaryTreePaths(root);
        for (String line : res) {
            System.out.println(line);
        }
    }

    //Given a ternary tree (each node of the tree has at most three children), find all root-to-leaf paths.
    //Input:: 1 3 2 1 5 0 3 0 4 0 :: //Tree dfs is 1 2 5 3 4
    // public static List<String> ternaryTreePaths(Node<Integer> root) {
    //     // WRITE YOUR BRILLIANT CODE HERE
    //     return List.of();
    // }

    public static List<String> ternaryTreePaths(Node<Integer> root) {
        ArrayList<String> res = new ArrayList<>();
        if (root != null) dfs(root, new ArrayList<String>(), res);
        return res;
    }

    private static void dfs(Node<Integer> root, ArrayList<String> path, ArrayList<String> res) {
        // exit condition, reached leaf node, append paths to results
        if (root.children.size() == 0) {
            path.add(Integer.toString(root.val));
            res.add(String.join("->", path));
            path.remove(path.size() - 1);
            return;
        }
        // dfs on each non-null child
        for (Node<Integer> child : root.children) {
            if (child != null) {
                path.add(Integer.toString(root.val));
                dfs(child, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        int num = Integer.parseInt(iter.next());
        ArrayList<Node<T>> children = new ArrayList<>();
        for (int i = 0; i < num; i++)
            children.add(buildTree(iter, f));
        return new Node<T>(f.apply(val), children);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? Collections.emptyList() : Arrays.asList(s.split(" "));
    }

    public static class Node<T> {
        public T val;
        public List<Node<T>> children;

        public Node(T val) {
            this(val, new ArrayList<>());
        }

        public Node(T val, List<Node<T>> children) {
            this.val = val;
            this.children = children;
        }
    }
}
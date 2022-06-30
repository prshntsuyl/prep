import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

class MyBFS {

    public static void main(String[] args) {
        Node<Integer> node10 = new Node<>(10, null, null);
        Node<Integer> node11 = new Node<>(11, null, null);

        Node<Integer> node6 = new Node<>(6, null, null);
        Node<Integer> node7 = new Node<>(7, null, null);

        Node<Integer> node3 = new Node<>(3, node10, node11);
        Node<Integer> node4 = new Node<>(4, null, null);
        Node<Integer> node5 = new Node<>(5, node7, node6);

        Node<Integer> node2 = new Node<>(2, node4, node5);
        Node<Integer> node1 = new Node<>(1, node2, node3);

        bfs(node1);
        dfs(node1);

        int max = dfs_recursive_find_max(node1, -1);
        System.out.println("found max to be:: " + max);
    }

    private static void bfs(MyBFS.Node<Integer> node1) {
        System.out.println("Start!!! BFS");

        ArrayDeque<Node<Integer>> arrayDeque = new ArrayDeque<>();

        arrayDeque.add(node1);

        while (!arrayDeque.isEmpty()) {
            MyBFS.Node<Integer> pop = arrayDeque.pop();

            System.out.println(pop.value + " ");

            if (pop.left != null) {
                arrayDeque.add(pop.left);
            }
            if (pop.right != null) {
                arrayDeque.add(pop.right);
            }

        }
    }


    private static int dfs_recursive_find_max(MyBFS.Node<Integer> node1, int max) {
        if(node1 == null ) {
            return -1;
        }

        if(node1.left == null && node1.right == null) {
            return node1.value;
        }

        if(node1.left == null && node1.right != null) {
            return node1.right.value;
        }

        if(node1.left != null && node1.right == null) {
            return node1.left.value;
        }

        Integer left = dfs_recursive_find_max(node1.left, max);
        Integer right = dfs_recursive_find_max(node1.right, max);

        if(left >= right) {
            max = left;
        } else {
            max = right;
        }

        return max;
    }

    //iterative approach with stack
    private static void dfs(MyBFS.Node<Integer> node1) {
        System.out.println("Start DFS!!!");
        // Base Case
        if (node1 == null) {
            return;
        }

        // Create an empty stack and push root to it
        Stack<Node<Integer>> nodeStack = new Stack<>();
        nodeStack.push(node1);

        while (nodeStack.empty() == false) {

            // Pop the top item from stack and print it
            Node<Integer> mynode = nodeStack.peek();
            System.out.print(mynode.value + " ");
            nodeStack.pop();

            // Push right and left children of the popped node to stack
            if (mynode.right != null) {
                nodeStack.push(mynode.right);
            }
            if (mynode.left != null) {
                nodeStack.push(mynode.left);
            }
        }
    }

    private static void dfs_0(MyBFS.Node<Integer> node1) {
        System.out.println("Start!!! DFS");

        ArrayDeque<Node<Integer>> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(node1);

        ArrayList<Integer> arrayList = new ArrayList<>();

        while (!arrayDeque.isEmpty()) {
            MyBFS.Node<Integer> peekLast = arrayDeque.peekLast();
            Integer value = peekLast.value;

            if (!arrayList.contains(value)) {
                arrayList.add(value);
                System.out.print(value + " ");
            } else {
                arrayDeque.pollLast();
                continue;
            }

            if (peekLast.left != null) {
                arrayDeque.add(peekLast.left);
            } else if (peekLast.right == null) {
                arrayDeque.pollLast();
                MyBFS.Node<Integer> right = arrayDeque.peekLast().right;
                if (right != null) {
                    arrayDeque.add(right);
                }
            }

        }

    }

    static class Node<T> {

        T value;
        Node<T> left;
        Node<T> right;

        Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }
}
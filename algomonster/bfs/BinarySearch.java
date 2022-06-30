class BinarySearch {

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

        boolean binarySearch = binarySearch(node1, 3);
        System.out.println(binarySearch);

    }

    
    private static boolean binarySearch(BinarySearch.Node<Integer> node1, int target) {
        if(node1 == null) {
            return false;
        }

        if(node1.value == target) {
            return true;
        }

        if (node1.left!=null && target > node1.left.value) {
            return binarySearch(node1.right, target);
        }

        return binarySearch(node1.left, target);

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
package practice.treeq.bst;


class CheckBST {
    public static void main(String[] args) {
        Node three = new Node(3);
        Node two = new Node(2);

        Node five = new Node(5);
        Node one = new Node(1);
        Node four = new Node(4);

        two.left = one;
        two.right = four;

        three.left = two;
        three.right = five;

        System.out.println(isBST(three));
    }

    static boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBSTUtil(Node root, int min, int max) {
        if(root == null) {
            return true;
        }

        if (root.data < min || root.data > max) {
            return false;
        }

        //* remember this condition
        return isBSTUtil(root.left, min, root.data-1) && isBSTUtil(root.right, root.data+1, max);
    }

    static boolean isBST_not_optimal(Node root) {
        // code here.
        if(root.left == null && root.right == null) {
            return true;
        } else if(root.left != null && root.right == null) {
            return isBST(root.left);
        } else if(root.right != null && root.left == null) {
            return isBST(root.right);
        }

        if(isBST(root.left) && isBST(root.right)) {
            if(root.left.data < root.data && root.right.data > root.data) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    static class Node {

        public int data;
        public Node left;
        public Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
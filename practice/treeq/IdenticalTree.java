package practice.treeq;

/**
 * IdenticalTree
 */
public class IdenticalTree {

    /*
     * Expected Time Complexity: O(N). Expected Auxiliary Space: O(Height of the
     * Tree).
     */
    public static void main(String[] args) {
        Node firstNode = new Node(1);
        {
            Node secondNode = new Node(2);
            Node thirdNode = new Node(3);

            firstNode.left = secondNode;
            firstNode.right = thirdNode;
        }

        Node aNode = new Node(1);
        {
            Node bNode = new Node(2);
            Node cNode = new Node(3);

            aNode.left = bNode;
            aNode.right = cNode;
        }

        System.out.println(isIdentical(aNode, firstNode));
    }

    static boolean isIdentical(Node root1, Node root2) {
        // Code Here
        if (root1 == null) {
            return isIdentical(root2.left, root2.right);
        }

        if (root2 == null) {
            return isIdentical(root1.left, root1.right);
        }

        if (root1.data != root2.data) {
            return false;
        }

        if (root1.left == null && root1.right == null && root2.left == null && root2.right == null) {
            return true;
        }

        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    // Good solution with less if conditions
    static boolean identical(Node a, Node b) {
        /* 1. both empty */
        if (a == null && b == null)
            return true;

        /* 2. both non-empty -> compare them */
        if (a != null && b != null)
            return (a.data == b.data && identical(a.left, b.left) && identical(a.right, b.right));

        /* 3. one empty, one not -> false */
        return false;
    }

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }
}

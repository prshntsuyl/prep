package practice.treeq;

/**
 * MirrorTree
 */
public class MirrorTree {

    public static void main(String[] args) {
        Node firstNode = new Node(1);
        {
            Node secondNode = new Node(2);
            Node thirdNode = new Node(3);

            firstNode.left = secondNode;
            firstNode.right = thirdNode;

            Node fourthNode = new Node(4);
            secondNode.left = fourthNode;
        }

        mirror(firstNode);
    }

    static void mirror(Node node) {
        // Your code here
        //
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        if (node.left != null) {
            mirror(node.left);
        }
        if (node.right != null) {
            mirror(node.right);
        }
    }

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
}

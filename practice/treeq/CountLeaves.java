package practice.treeq;

/**
 * CountLeaves
 */
public class CountLeaves {

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

        Node aNode = new Node(1);
        {
            Node bNode = new Node(2);
            Node cNode = new Node(3);

            aNode.left = bNode;
            aNode.right = cNode;
        }

        System.out.println(countLeaves(firstNode));
    }

    static int countLeaves(Node node) {
        // Your code
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeaves(node.left) + countLeaves(node.right);
    }

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}

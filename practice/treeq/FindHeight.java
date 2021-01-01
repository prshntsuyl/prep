package practice.treeq;

/**
 * FindHeight
 */
public class FindHeight {

    public static void main(String[] args) {
        Node firstNode = new Node(1);
        {
            Node secondNode = new Node(2);
            Node thirdNode = new Node(3);

            firstNode.left = secondNode;
            firstNode.right = thirdNode;

            {
                Node fourthNode = new Node(4);
                Node fifthNode = new Node(5);

                secondNode.left = fourthNode;
                fourthNode.left = fifthNode;
            }
        }

        System.out.println(height(firstNode));
    }

    static int height(Node node) {
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.left != null && node.right == null) {
            return height(node.left) + 1;
        }
        if (node.left == null && node.right != null) {
            return height(node.right) + 1;
        }
        // code here
        return Math.max(height(node.left), height(node.right)) + 1;
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

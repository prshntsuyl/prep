package practice.treeq;

import java.util.ArrayList;
import java.util.List;

/**
 * FindLCA
 */
public class FindLCA {

    public static void main(String[] args) {
        Node firstNode = new Node(4);
        {
            Node secondNode = new Node(3);
            // Node thirdNode = new Node(5);

            firstNode.left = secondNode;
            // firstNode.right = thirdNode;

            // {
            // Node fourthNode = new Node(2);
            // Node fifthNode = new Node(1);

            // secondNode.left = fourthNode;
            // fourthNode.left = fifthNode;
            // }
        }

        System.out.println(LCA(firstNode, 3, 4).data);
    }

    static Node LCA(Node root, int n1, int n2) {
        if (n1 == n2 || n1 == root.data || n2 == root.data) {
            return root;
        }

        List<Node> listOfFirst = new ArrayList<>();
        listOfFirst = traverse(root, n1, listOfFirst);

        List<Node> listOfSecond = new ArrayList<>();
        listOfSecond = traverse(root, n2, listOfSecond);

        for (int i = listOfSecond.size() - 1; i > -1; i--) {
            for (int j = listOfFirst.size() - 1; j > -1; j--) {
                if (listOfSecond.get(i).equals(listOfFirst.get(j))) {
                    return listOfSecond.get(j);
                }
            }
        }

        return root;
    }

    static List<Node> traverse(Node node, int target, List<Node> listOfFirst) {
        int rootdata = node.data;

        if (target == node.data) {
            return listOfFirst;
        }

        if (target < rootdata) {
            listOfFirst.add(node.left);
            return traverse(node.left, target, listOfFirst);
        } else {
            listOfFirst.add(node.right);
            return traverse(node.right, target, listOfFirst);
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}

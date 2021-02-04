package practice.treeq.bst;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.List;
import java.util.stream.Collectors;

class ArrayToBST {
    public static void main(String[] args) {
        int[] sortedArray = new int[] {1, 2, 3, 4, 5, 6, 7};
        sortedArrayToBST(sortedArray);
    }

    static int[] sortedArrayToBST(int[] nums) {
        // Code here
        int size = nums.length;
        Node rootNode = sortedArrayToBST(nums, 0, size - 1);
        int[] outputArr = new int[nums.length];
        List<Integer> output = new ArrayList<>(); 
        preOrderPrint(rootNode, output);

        for (int i=0; i<output.size(); i++ ) {
           outputArr[i] = output.get(i);
        }
        return outputArr;
    }

    static void preOrderPrint(Node rootNode, List<Integer> output) {
        if (rootNode == null) {
            return;
        }

        output.add(rootNode.data); 

        preOrderPrint(rootNode.left, output);
        preOrderPrint(rootNode.right, output);
    }

    static Node sortedArrayToBST(int[] nums, int min, int max) {
        if(min > max) {
            return null;
        }

        int midPoint = (min + max) / 2;
        Node midNode = new Node(nums[midPoint]);

        midNode.left = sortedArrayToBST(nums, min, midPoint - 1);
        midNode.right = sortedArrayToBST(nums, midPoint + 1, max);

        return midNode;
    }


    //classic mistake could have been avoided
    //better way is do recursion with tree get the final node and top of it perform pre-order
    static public int[] sortedArrayToBST_unoptimized(int[] nums) {
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> input = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            input.add(nums[i]);
        }

        List<Integer> preOrderList = sortedArrayToBSTWithArray(input, preOrder);
        preOrderList.stream().map(i -> i + ", ").forEach(System.out::print);

        int[] output = new int[nums.length];
        for (int i = 0; i < preOrderList.size(); i++) {
            output[i] = preOrderList.get(i);
        }

        return output;
    }

    static public List<Integer> sortedArrayToBSTWithArray(List<Integer> nums, List<Integer> preOrder) {
        // Code here
        int size = nums.size();

        if (size == 0) {
            return preOrder;
        }


        int leftTreeSize;
        int rightTreeSize;
        int midIndex = size / 2;

        if(size % 2 == 0) {
            leftTreeSize = size / 2;
            rightTreeSize = size / 2;
        } else {
            leftTreeSize = size / 2 + 1;
            rightTreeSize = size / 2;
        }

        int mid = nums.get(midIndex);
        preOrder.add(mid);

        System.out.println("midIndex: " + midIndex);
        if(midIndex > 0) {
            List<Integer> leftArray = IntStream.range(0, midIndex)
                                      .map(i -> nums.get(i))
                                      .boxed()
                                      .collect(Collectors.toList());

            List<Integer> rightArray = IntStream.range(midIndex + 1, nums.size())
                                       .map(i -> nums.get(i))
                                       .boxed()
                                       .collect(Collectors.toList());

            preOrder.addAll(sortedArrayToBSTWithArray(leftArray, preOrder));
            preOrder.addAll(sortedArrayToBSTWithArray(rightArray, preOrder));
        }

        return preOrder;
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
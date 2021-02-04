package practice.treeq.bst;

import java.util.List;
import java.util.ArrayList;

class ArrayToBST {
    public static void main(String[] args) {
        int[] sortedArray = new int[] {1, 2, 3, 4, 5};
        ListsortedArrayToBST(sortedArray));
    }

    static public int[] sortedArrayToBST(int[] nums) {
        List<Integer> preOrder = new ArrayList<>();
        return sortedArrayToBSTWithArray(nums, preOrder);
    }

    static public int[] sortedArrayToBSTWithArray(int[] nums, List<Integer> preOrder) {
        // Code here

    	if (nums.length == 0) {
    		return preOrder;
    	}

        int size = nums.length;

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

        int mid = nums[midIndex];
        preOrder.add(mid);

        int[] leftArray = IntStream.range(0, midIndex-1)
                        .map(i -> arra[i])
                        .toArray();

        int[] rightArray = IntStream.range(midIndex+1, num.length-1)
                        .map(i -> arra[i])
                        .toArray();

        preOrder.add(sortedArrayToBSTWithArray(leftArray, preOrder));
        preOrder.add(sortedArrayToBSTWithArray(rightArray, preOrder));

        return preOrder;
    }
}
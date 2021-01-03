package practice.heapify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * HeapSort
 */
public class HeapSort {

    /*
     * Given an array of size N. The task is to sort the array elements by
     * completing functions heapify() and buildHeap() which are used to implement
     * Heap Sort.
     */
    public static void main(String[] args) {
        // int N = 5;
        // int[] arr = { 4, 1, 3, 9, 7 };
        // heapify(arr, N, N);

        List<Integer> elements = Arrays.asList(3, 5, 1, 4, 2);
        List<Integer> sortedElements = Heap.sort(elements);

        System.out.println(sortedElements);
    }

    void buildHeap(int[] arr, int n) {
        // Your code here
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(int[] arr, int n, int i) {
        // Your code here
    }

    static class BinaryTree<E> {

        List<E> elements = new ArrayList<>();

        // takes O(logn) time
        void add(E e) {
            elements.add(e);
        }

        boolean isEmpty() {
            return elements.isEmpty();
        }

        E elementAt(int index) {
            return elements.get(index);
        }

        int parentIndex(int index) {
            return (index - 1) / 2;
        }

        int leftChildIndex(int index) {
            return 2 * index + 1;
        }

        int rightChildIndex(int index) {
            return 2 * index + 2;
        }

    }

    static class Heap<E extends Comparable<E>> {

        private List<E> elements = new ArrayList<>();

        public static <E extends Comparable<E>> List<E> sort(Iterable<E> elements) {
            Heap<E> heap = of(elements);

            List<E> result = new ArrayList<>();

            while (!heap.isEmpty()) {
                result.add(heap.pop());
            }

            return result;
        }

        public static <E extends Comparable<E>> Heap<E> of(E... elements) {
            return of(Arrays.asList(elements));
        }

        public static <E extends Comparable<E>> Heap<E> of(Iterable<E> elements) {
            Heap<E> result = new Heap<>();
            for (E element : elements) {
                result.add(element);
            }
            return result;
        }

        public void add(E e) {
            elements.add(e);
            int elementIndex = elements.size() - 1;
            while (!isRoot(elementIndex) && !isCorrectChild(elementIndex)) {
                int parentIndex = parentIndex(elementIndex);
                swap(elementIndex, parentIndex);
                elementIndex = parentIndex;
            }
        }

        public E pop() {
            if (isEmpty()) {
                throw new IllegalStateException("You cannot pop from an empty heap");
            }

            E result = elementAt(0);

            int lasElementIndex = elements.size() - 1;
            swap(0, lasElementIndex);
            elements.remove(lasElementIndex);

            int elementIndex = 0;
            while (!isLeaf(elementIndex) && !isCorrectParent(elementIndex)) {
                int smallerChildIndex = smallerChildIndex(elementIndex);
                swap(elementIndex, smallerChildIndex);
                elementIndex = smallerChildIndex;
            }

            return result;
        }

        public boolean isEmpty() {
            return elements.isEmpty();
        }

        private boolean isRoot(int index) {
            return index == 0;
        }

        private int smallerChildIndex(int index) {
            int leftChildIndex = leftChildIndex(index);
            int rightChildIndex = rightChildIndex(index);

            if (!isValidIndex(rightChildIndex)) {
                return leftChildIndex;
            }

            if (elementAt(leftChildIndex).compareTo(elementAt(rightChildIndex)) < 0) {
                return leftChildIndex;
            }

            return rightChildIndex;
        }

        private boolean isLeaf(int index) {
            return !isValidIndex(leftChildIndex(index));
        }

        private boolean isCorrectParent(int index) {
            return isCorrect(index, leftChildIndex(index)) && isCorrect(index, rightChildIndex(index));
        }

        private boolean isCorrectChild(int index) {
            return isCorrect(parentIndex(index), index);
        }

        private boolean isCorrect(int parentIndex, int childIndex) {
            if (!isValidIndex(parentIndex) || !isValidIndex(childIndex)) {
                return true;
            }

            return elementAt(parentIndex).compareTo(elementAt(childIndex)) < 0;
        }

        private boolean isValidIndex(int index) {
            return index < elements.size();
        }

        private void swap(int index1, int index2) {
            E element1 = elementAt(index1);
            E element2 = elementAt(index2);
            elements.set(index1, element2);
            elements.set(index2, element1);
        }

        private E elementAt(int index) {
            return elements.get(index);
        }

        private int parentIndex(int index) {
            return (index - 1) / 2;
        }

        private int leftChildIndex(int index) {
            return 2 * index + 1;
        }

        private int rightChildIndex(int index) {
            return 2 * index + 2;
        }

    }

}

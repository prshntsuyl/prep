package practice.recursion;

public class Josephus {

    public static void main(String[] args) {
        System.out.println(josephus(7, 3));
    }

    static int josephus(int n, int k) {
        // Your code here
        if (n == 1) {
            return 1; // josephus(1, k) = 1
        }
        return ((josephus(n - 1, k)) + k - 1) % n + 1;
    }
}

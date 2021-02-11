package practice.stacks;

import java.util.Stack;

// #57th problem
// naive solution is to get sum = 0 for a single row
//could reduce down the comparisons done
class CelebrityProblem {


    public static void main(String[] args) {
        System.out.println("Hello!!");

        int[][] M = new int[2][2];
        int n = 2;

        M[0][0] = 0;
        M[0][1] = 1;
        M[1][0] = 1;
        M[1][1] = 0;

        System.out.println(celebrity(M, n));
    }

    static int celebrity(int M[][], int n) {
        // code here
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while(stack.size() > 1) {
            Integer top = stack.pop();
            Integer next = stack.peek();

            if (M[top][next] == 0) {
                stack.pop();
                stack.push(top);
            }

        }

        int sum = 0;
        int potentialCeleb = stack.peek();

        for (int i = 0; i < n; i++) {
            sum = sum + M[potentialCeleb][i];
        }

        if (sum == 0) {
            int verify = 0;
            for (int i = 0; i < n; i++) {
                verify = verify + M[i][potentialCeleb];
            }

            if (verify == n - 1) {
                return potentialCeleb;
            }
        }
        return -1;
    }
}

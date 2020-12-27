package practice.stacks;

import java.util.Stack;

class GetMinima {

  /*
   * You are given N elements and your task is to Implement a Stack in which you
   * can get minimum element in O(1) time. You are required to complete the three
   * methods push() which take one argument an integer 'x' to be pushed into the
   * stack, pop() which returns a integer poped out from the stack and getMin()
   * which returns the min element from the stack. (-1 will be returned if for
   * pop() and getMin() the stack is empty.)
   *
   * Expected Time Complexity : O(1) for all the 3 methods. Expected Auixilliary
   * Space : O(1) for all the 3 methods.
   */
  public static void main(String[] args) {
    System.out.println();

  }

  static class GfG {
    int minEle;
    Stack<Integer> s;

    /* returns min element from stack */
    int getMin() {
      // Your code here
      if (s.empty()) {
        return -1;
      }
      return minEle;
    }

    /* returns poped element from stack */
    int pop() {
      // Your code here
      if (s.empty()) {
        return -1;
      }
      int popped = s.pop();
      if (minEle == popped) {
        minEle = 9999;
      }
      return popped;
    }

    /* push element x into the stack */
    void push(int x) {
      // Your code here
      if (minEle > x) {
        minEle = x;
      }
      s.push(x);
    }
  }
}

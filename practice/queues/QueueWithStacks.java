package practice.queues;

import java.util.Stack;

class QueueWithStacks {

  /*
   * Expected Time Complexity : O(1) for both push() and O(N) for pop(). Expected
   * Auxilliary Space : O(N).
   */
  public static void main(String[] args) {
    System.out.println("!!!");
  }

  class StackQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    /*
     * The method insert to push element into the queue
     */
    void Push(int x) {
      // Your code here
      while (!s2.isEmpty()) {
        s1.push(s2.pop());
      }
      s1.push(x);
    }

    /*
     * The method remove which return the element popped out of the queue
     */
    int Pop() {
      // Your code here
      while (!s1.isEmpty()) {
        s2.push(s1.pop());
      }

      if (s2.isEmpty()) {
        return -1;
      } else {
        return s2.pop();
      }

    }
  }

  // if question was create stack from two queue
  class StackFromTwoQueue {
    StackQueue<Integer> s1 = new StackQueue<Integer>();
    StackQueue<Integer> s2 = new StackQueue<Integer>();

    /*
     * The method insert to push element into the queue
     */
    void Push(int x) {
      // until q2 is empty then only push
    }

    /*
     * The method remove which return the element popped out of the queue
     */
    int Pop() {
      // until q1 is empty push in q2 and dont push last element and return it
    }
  }
}

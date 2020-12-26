package practice.linklist;

import java.lang.Math;

class MiddleElement {
  /*
   * Given a singly linked list of N nodes. The task is to find the middle of the
   * linked list. For example, if given linked list is 1->2->3->4->5 then the
   * output should be 3. If there are even nodes, then there would be two middle
   * nodes, we need to print the second middle element. For example, if given
   * linked list is 1->2->3->4->5->6 then the output should be 4.
   *
   * O(N): Time and O(1): auxillary
   */
  public static void main(String[] args) {
    // Input:
    // LinkedList: 1->2->3->4->5
    // Output: 3

    Node nodo1 = new Node(1);
    Node nodo2 = new Node(2);
    Node nodo3 = new Node(3);
    Node nodo4 = new Node(4);
    Node nodo5 = new Node(5);
    Node nodo6 = new Node(6);

    nodo1.next = nodo2;
    nodo2.next = nodo3;
    nodo3.next = nodo4;
    nodo4.next = nodo5;
    nodo5.next = nodo6;

    System.out.println(getMiddle(nodo1));
  }

  static int getMiddle(Node head) {
    Node initial = head;
    // Your code here.
    int count = 0;

    while (head.next != null) {
      count++;
      head = head.next;
    }
    count++;
    head = head.next;

    double mid = count / 2;
    mid = mid + 1;

    for (int i = 2; i < mid + 1; i++) {
      initial = initial.next;
    }

    return initial.data;
  }

  // link list node
  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

}

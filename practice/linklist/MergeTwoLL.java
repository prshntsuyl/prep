package practice.linklist;

class MergeTwoLL {

  /*
   * Given two sorted linked lists consisting of N and M nodes respectively. The
   * task is to merge both of the list (in-place) and return head of the merged
   * list. Note: It is strongly recommended to do merging in-place using O(1)
   * extra space.
   *
   * Expected Time Complexity : O(n+m) Expected Auxilliary Space : O(1)
   */
  public static void main(String[] args) {
    Node nodo1 = new Node(2);
    Node nodo2 = new Node(4);
    Node nodo3 = new Node(5);

    Node nodo11 = new Node(3);
    Node nodo12 = new Node(4);
    Node nodo13 = new Node(4);

    nodo1.next = nodo2;
    nodo2.next = nodo3;

    nodo11.next = nodo12;
    nodo12.next = nodo13;

    Node sorted = sortedMerge(nodo1, nodo11);

    while (sorted.next != null) {
      System.out.println(sorted.data);
      sorted = sorted.next;
    }
    System.out.println(sorted.data);

  }

  // Method-1: using recursion
  public static Node sortedMerge(Node A, Node B) {
    if (A == null)
      return B;
    if (B == null)
      return A;

    if (A.data < B.data) {
      A.next = sortedMerge(A.next, B);
      return A;
    } else {
      B.next = sortedMerge(A, B.next);
      return B;
    }

  }

  // Method-2
  // Another approach is to use a different/separate node and simply pick from the
  // link list

  // Method-3
  // This had bugs
  // static Node sortedMerge(Node headA, Node headB) {
  // Node original = headA;
  // // This is a "method-only" submission.
  // // You only need to complete this method
  // while (headA.next != null) {
  // if (headB == null || headA.data < headB.data) {
  // System.out.println("first" + headA.data);
  // headA = headA.next;
  // } else {
  // Node ownNext = headA;
  // headA = headB;
  // headB = headB.next;
  //
  // headA.next = ownNext;
  // System.out.println("second" + headA.data);
  //
  // headA = headA.next;
  // // System.out.println("secnext" + headA.next.data);
  // }
  // }
  //
  // headA = headA.next;
  // return original;
  // }

  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

}

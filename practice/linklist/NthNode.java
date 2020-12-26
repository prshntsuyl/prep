package practice.linklist;

class NthNode {

  /*
   * Expected Time Complexity: O(N). Expected Auxiliary Space: O(1).
   */
  public static void main(String[] args) {
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

    System.out.println(getNthFromLast(nodo1, 7));

  }

  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  static int getNthFromLast(Node head, int n) {
    // Your code here
    Node firstPointer = head;
    for (int i = 1; i < n; i++) {
      firstPointer = firstPointer.next;
      if (firstPointer == null) {
        return -1;
      }
    }
    Node secondPointer = head;

    if (firstPointer == null) {
      return -1;
    }

    while (firstPointer.next != null) {
      firstPointer = firstPointer.next;
      secondPointer = secondPointer.next;
    }

    return secondPointer.data;
  }

}

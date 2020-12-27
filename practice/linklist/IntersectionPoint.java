package practice.linklist;

class IntersectionPoint {

  /*
   * Intersection Point in Y Shapped Linked Lists Expected Time Complexity: O(N+M)
   * Expected Auxiliary Space: O(1)
   */
  public static void main(String[] args) {
    Node nodo1 = new Node(2);
    Node nodo2 = new Node(4);
    Node nodo3 = new Node(5);

    Node nodo11 = new Node(3);
    Node nodo12 = new Node(4);
    Node nodo13 = new Node(5);

    nodo1.next = nodo2;
    nodo2.next = nodo3;

    nodo11.next = nodo12;
    nodo12.next = nodo13;

    System.out.println(intersectPoint(nodo1, nodo11));

  }

  // Solution
  // Method 3(Using difference of node counts)
  //
  // Get count of the nodes in the first list, let count be c1.
  // Get count of the nodes in the second list, let count be c2.
  // Get the difference of counts d = abs(c1 – c2)
  // Now traverse the bigger list from the first node till d nodes so that from
  // here onwards both the lists have equal no of nodes
  // Then we can traverse both the lists in parallel till we come across a common
  // node. (Note that getting a common node is done by comparing the address of
  // the nodes)
  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  static int intersectPoint(Node head1, Node head2) {

    Node firstList = reverseList(head1);
    Node secondList = reverseList(head2);

    int value = -1;
    while (secondList.data == firstList.data) {
      value = secondList.data;
      secondList = secondList.next;
      firstList = firstList.next;
    }

    return value;
    // code here
  }

  static Node reverseList(Node previous) {
    Node pointer = previous.next;
    previous.next = null;

    if (pointer == null) {
      return previous;
    }

    while (pointer.next != null) {
      Node prevprev = previous;
      previous = pointer;
      pointer = pointer.next;
      previous.next = prevprev;
    }

    Node prevprev = previous;
    previous = pointer;
    previous.next = prevprev;

    return previous;
  }

}

package practice.linklist;

class ReverseLinkList {

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

    Node newLL = reverseList(nodo1);
    while (newLL.next != null) {
      System.out.println(newLL.value);
      newLL = newLL.next;
    }
    System.out.println(newLL.value);
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

  static class Node {
    int value;
    Node next;

    Node(int value) {
      this.value = value;
    }
  }

}

package practice.linklist;

class DetectLoop {

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
    nodo6.next = nodo1; // cyclic

    System.out.println(detectLoop(nodo1));

  }

  public static boolean detectLoop(Node head) {
    Node firstPointer = head;
    Node secondPointer = head;

    while (head != null) {
      firstPointer = firstPointer.next;
      if (firstPointer == null) {
        return false;
      }
      firstPointer = firstPointer.next;
      if (firstPointer == null) {
        return false;
      }
      secondPointer = secondPointer.next;

      if (firstPointer == secondPointer) {
        return true;
      }
    }
    // Add code here
    return false;
  }

  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

}

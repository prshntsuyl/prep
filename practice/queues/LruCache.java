package practice.queues;

import java.util.LinkedList;
import java.util.Queue;

class LruCache {
  public static void main(String[] args) {
    System.out.println("!!!");
  }

  // use doubly linked list and HashMap to solve this
  static class LRUCache {
    Queue<Integer> q1 = new LinkedList<>();

    LRUCache(int cap) {
      // Intialize the cache capacity with the given
      // cap
    }

    // This method works in O(1)
    public static int get(int key) {
      // your code here
      return 0;
    }

    // This method works in O(1)
    public static void set(int key, int value) {
      // your code here
    }
  }
}

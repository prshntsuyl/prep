package practice.stacks;

import java.util.Map;
import java.util.Stack;
import java.util.HashMap;

class NextLarger {

  public static void main(String[] args) {
    long[] longArr = { 4, 5, 2, 24 };
    long[] result = nextLargerElement(longArr, longArr.length);

    for (int i = 0; i < longArr.length; i++) {
      System.out.println(result[i]);
    }
  }

  public static long[] nextLargerElement(long[] longArr, int n) {
    // Your code here
    long[] resultArr = new long[n];
    Map<Long, Long> resultMap = new HashMap<>();
    Stack<Long> stackNode = new Stack<>();

    stackNode.push(longArr[0]);
    for (int i = 1; i < n - 1; i++) {
      if (!stackNode.isEmpty()) {
        long top = stackNode.peek();
        long next = longArr[i];

        while (next > top) {
          stackNode.pop();
          resultMap.put(top, next);

          if (stackNode.isEmpty()) {
            break;
          } else {
            top = stackNode.peek();
          }

        }
      } else {
        stackNode.push(longArr[i]);
      }

    }

    // long popped = stackNode.pop();
    // while (!stackNode.isEmpty()) {
    // long minus = -1;
    // resultMap.put(popped, minus);
    // }

    for (int i = 0; i < n; i++) {
      if (resultMap.containsKey(longArr[i])) {
        resultArr[i] = resultMap.get(longArr[i]);
      } else {
        resultArr[i] = -1;
      }

    }

    return resultArr;
  }
}

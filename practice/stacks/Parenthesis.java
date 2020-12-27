package practice.stacks;

import java.util.List;
import java.util.ArrayList;

class Parenthesis {

  /*
   * Expected Time Complexity: O(|x|) Expected Auixilliary Space: O(|x|)
   */
  public static void main(String[] args) {
    System.out.println(ispar("{([])}"));
  }

  // Function to return if the paranthesis are balanced or not
  static boolean ispar(String x) {
    // add your code here
    char[] chars = x.toCharArray();
    StackNode stackNode = new StackNode(new ArrayList<>());

    for (int i = 0; i < chars.length; i++) {
      int currentSize = stackNode.current.size();

      if (currentSize == 0) {
        stackNode.push(Character.toString(chars[i]));
      } else {
        char latestChar = stackNode.peek().charAt(0);

        switch (chars[i]) {
        case '}':
          if (latestChar == '{') {
            stackNode.pop();
          } else {
            stackNode.push(Character.toString(chars[i]));
          }
          break;
        case ']':
          if (latestChar == '[') {
            stackNode.pop();
          } else {
            stackNode.push(Character.toString(chars[i]));
          }
          break;
        case ')':
          if (latestChar == '(') {
            stackNode.pop();
          } else {
            stackNode.push(Character.toString(chars[i]));
          }
          break;
        default:
          stackNode.push(Character.toString(chars[i]));
          break;
        }

      }
    }

    if (stackNode.current.size() == 0) {
      return true;
    }
    return false;
  }

  static class StackNode {
    List<String> current;

    StackNode() {
    }

    StackNode(List<String> current) {
      this.current = current;
    }

    void push(String element) {
      current.add(element);
    }

    String pop() {
      String element = peek();
      current.remove(current.size() - 1);

      return element;
    }

    String peek() {
      int currentSize = current.size();
      String element = current.get(currentSize - 1);

      return element;
    }

  }
}

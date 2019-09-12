/**
* ReadWrite.java
* Author: Johan Carlsson
* Created: 2019-09-08
*
* The program reads a line from stdin and prints it in reversed order
*/

import java.util.Scanner;

public class ReadWrite {
  Stack<Character> stack = new Stack<Character>();

  // Create new ReadWrite object
  public ReadWrite() {}

  // Used to reverse given String
  public String reverse(String str) {
      char[] chrString = str.toCharArray();
      StringBuilder sb = new StringBuilder();

      // Push chars to stack
      for (char c : chrString) {
        stack.push(c);
      }

      // Build reversed String by poping from stack
      while (!stack.isEmpty()) {
        sb.append(stack.pop());
      }

      return sb.toString();
  }

  // Main method taking input from readin
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in, "utf-8");
    ReadWrite rw = new ReadWrite();

    // Read and reverse next line
    while (sc.hasNextLine()) {
      String str = sc.nextLine();
      String reversedString = rw.reverse(str);
      System.out.println(reversedString);
    }

    // Test reverse function
    assert(rw.reverse("").equals(""));
    assert(rw.reverse(" test").equals("tset "));
    assert(rw.reverse("hej hej hej").equals("jeh jeh jeh"));
    assert(rw.reverse("123").equals("321"));
    assert(rw.reverse("\t\n\t\'hej").equals("jeh\'\t\n\t"));
  }
}

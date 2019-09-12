/**
* BalanceFilter.java
* Author: Johan Carlsson
* Created: 2019-09-07
*
* Check if a given file has a balanced set of parenteces
* Checks ([{ and coresponding closing brackets
*/

import java.util.Scanner;

public class BalanceFilter {
  boolean status;
  Stack<Character> chars = new Stack<Character>();

  /**
  * Create new instance of BalanceFilter
  */
  public BalanceFilter() {
    status = true;
  }

  /**
  * Add a line to check
  */
  public void check(String str) {
    char[] chrsInStr = str.toCharArray();
    boolean status = true;
    for (char c : chrsInStr) {
        check (c);
    }
  }

  // Check characters
  private void check(char c) {
    switch (c) {
      case '(':
      case '[':
      case '{': chars.push(c);
                break;
      case ')': checkBalance('(');
                break;
      case ']': checkBalance('[');
                break;
      case '}': checkBalance('{');
    }
  }

  // Check Stack for expected character
  private void checkBalance(char expected) {
    if (chars.isEmpty()) {
      status = false;
    }
    else if (chars.pop() != expected) {
      status = false;
    }
  }

  /**
  * Get current status
  */
  private boolean status() {
    if (chars.isEmpty()) {
      return status;
    }
    return false;
  }
    
  /**
  * Main method, reading given lines and checks for status
  */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in, "utf-8");
    BalanceFilter bf = new BalanceFilter();

    while (sc.hasNext()) {
        bf.check(sc.next());
    }
    
    System.out.println(bf.status());

    // Tests
    BalanceFilter bf2 = new BalanceFilter();
    bf2.check("[[[(({}))]]]");
    assert(bf2.status());
    bf2 = new BalanceFilter();
    bf2.check("");
    assert(bf2.status());
    bf2 = new BalanceFilter();
    bf2.check("[");
    assert(!bf2.status());
    bf2 = new BalanceFilter();
    bf2.check(")");
    assert(!bf2.status());
    bf2 = new BalanceFilter();
    bf2.check("[[[(({}))]]");
    assert(!bf2.status());
    bf2 = new BalanceFilter();
    bf2.check("[[{[(({}))]}]]");
    assert(bf2.status());
    bf2 = new BalanceFilter();
    bf2.check("[[[{(({}))]]}]");
    assert(!bf2.status());
    bf2 = new BalanceFilter();
    bf2.check("[d[d[d(s(ad{asd}asd))asd]asd]]asd}asd");
    assert(!bf2.status());
  }
}

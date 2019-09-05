/**
  * MathEngine.java
  * Author: Johan Carlsson
  * Created: 2019-09-04
  *
  * Implements a stack based shunting yard algorithm
  *
  * API:
  * 
  */
public class MathEngine {

  private final Stack<Character> exp = new Stack<Character>();
  private final Stack<Character> ops = new Stack<Character>();
  private final Stack<Integer> nums = new Stack<Integer>();

  public MathEngine() {}

  public int evaluate(String str) {
    char[] parsedString = str.toCharArray();
    for (char c : parsedString) {
      exp.push(c);
    }

    evaluate();

    while (! ops.isEmpty()) {
      nums.push(useOp(ops.pop(), nums.pop(), nums.pop()));
    }

    return nums.pop();
  }

  private void evaluate() {
      while (! exp.isEmpty()) {
        char c = exp.pop();
        switch (c) {
          case ')': ops.push(c);
                    evaluate();
                    break;
          case '(': calc();
                    return;
          case '+': ops.push(c);
                    break;
          case '-': ops.push(c);
                    break;
          case '*': char next = exp.pop();
                    if (next == ')') {
                      ops.push(next);
                      evaluate();
                    }
                    else{
                      nums.push(Character.getNumericValue(next));
                    }
                    nums.push(useOp(c, nums.pop(), nums.pop()));
                    break;
          default: nums.push(Character.getNumericValue(c));
        }
      }
    }

  private void calc() {
    char op = ops.pop();
    while (op != ')') {
      nums.push(useOp(op, nums.pop(), nums.pop()));
      op = ops.pop();
    }
  }

  private int useOp(char op, int x, int y) {
    switch (op) {
      case '+': return x + y;
      case '-': return x - y;
      case '*': return x * y;
    }
    return 0;
  }

  public static void main(String[] args) {
    MathEngine me = new MathEngine();
    String s1 = "(4+3)*2";
    String s2 = "(((3)))";
    String s3 = "((3)-2)";
    System.out.println(me.evaluate(s1));
    System.out.println(me.evaluate(s2));
    System.out.println(me.evaluate(s3));

  }
}

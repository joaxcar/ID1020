import java.util.Scanner;

public class BalanceFilter {
  boolean status;
  Stack<Character> chars = new Stack<Character>();

  public BalanceFilter() {
    status = true;
  }

  public void check(String str) {
    char[] chrsInStr = str.toCharArray();
    boolean status = true;
    for (char c : chrsInStr) {
        check (c);
      }
    }

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

  private void checkBalance(char expected) {
    if (chars.isEmpty()) {
      status = false;
    }
    else if (chars.pop() != expected) {
      status = false;
    }
  }


  private boolean status() {
    if (chars.isEmpty()) {
      return status;
    }
    return false;
  }
    
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in, "utf-8");
    BalanceFilter bf = new BalanceFilter();

    while (sc.hasNext()) {
        bf.check(sc.next());
    }

    BalanceFilter bf2 = new BalanceFilter();
    System.out.println(bf2.status());
    bf2.check("[[[(({}))]]]");
    System.out.println(bf2.status());
    bf2 = new BalanceFilter();
    bf2.check("[[[({}))]]]");
    System.out.println(bf2.status());
    bf2 = new BalanceFilter();
    bf2.check("[[[(({}))]]");
    System.out.println(bf2.status());
    bf2 = new BalanceFilter();
    bf2.check("[[{[(({}))]}]]");
    System.out.println(bf2.status());
    bf2 = new BalanceFilter();
    bf2.check("[[[{(({}))]]}]");
    System.out.println(bf2.status());
    bf2 = new BalanceFilter();
    bf2.check("[d[d[d(s(ad{asd}asd))asd]asd]]asd}asd");
    System.out.println(bf2.status());
  }
}

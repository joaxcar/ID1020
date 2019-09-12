import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Example {
  public Example() {}

  public static <T extends Comparable<? super T>> void sort(T[] a) {
  }

  private static <T extends Comparable<? super T>> boolean less(T v, T w) {
    return v.compareTo(w) < 0;
  }

  private static <T extends Comparable<? super T>>  void exch(T[] a, int i, int j) {
    T t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  private static <T extends Comparable<? super T>> void show(T[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  public static <T extends Comparable<? super T>> boolean isSorted(T[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1])) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    while (StdIn.hasNextLine()) {
      String a = StdIn.readLine();
      String[] as = a.split(" ");
      sort(as);
      assert isSorted(as);
      show(as);
    }
  }
}

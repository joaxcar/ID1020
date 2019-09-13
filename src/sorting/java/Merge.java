import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.lang.reflect.Array;

public class Merge {
  public static <T extends Comparable<? super T>> void sort(T[] a) {
    @SuppressWarnings("unchecked")
    T[] aux = (T[]) new Comparable[a.length];
    sort(a, aux, 0, a.length - 1);
  }

  private static <T extends Comparable<? super T>> void sort(T[] a, T[] aux, int lo, int hi) {
    if (hi - lo < 10) {
      insertion(a, lo, hi);
      return;
    }
    int mid = lo + (hi - lo) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid + 1, hi);
    merge(a, aux, lo, mid, hi);
  }

  private static <T extends Comparable<? super T>> void insertion(T[] a, int start, int end) {
    for (int i = start; i <= end; i++) {
      T cur = a[i];
      int k = i - 1;
      while (k >= start && less(cur, a[k])) {
        a[k + 1] = a[k];
        k--;
      }
      a[k + 1] = cur;
    }
  }

  private static <T extends Comparable<? super T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {
    assert isSorted(a, lo, mid);
    assert isSorted(a, mid + 1, hi);

    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    int i = lo;
    int j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      }
      else if (j > hi) {
        a[k] = aux[i++];
      }
      else if (less(aux[i], aux[j])) {
        a[k] = aux[i++];
      }
      else {
        a[k] = aux[j++];
      }
    }

    assert isSorted(a, lo, hi);
  }


  private static <T extends Comparable<? super T>> boolean less(T v, T w) {
    return v.compareTo(w) < 0;
  }

  private static <T extends Comparable<? super T>>  void exch(T[] a, int i, int j) {
    T t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static <T extends Comparable<? super T>> void show(T[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  public static <T extends Comparable<? super T>> boolean isSorted(T[] a, int start, int end) {
    for (int i = start + 1; i < end; i++) {
      if (less(a[i], a[i - 1])) return false;
    }
    return true;
  }

  private static Integer[] useInt(String[] strs) {
    int size = strs.length;
    Integer[] ints = new Integer[size];
    for (int i = 0; i < size; i++) {
      ints[i] = Integer.parseInt(strs[i]);
    }
    return ints;
  }

  public static void main(String[] args) {
    if (args[0].equals("short")) {
      while (StdIn.hasNextLine()) {
        String a = StdIn.readLine();
        String[] as = a.split(" ");
        Stopwatch sw = new Stopwatch();
        sort(as);
        System.out.println(sw.elapsedTime());
        assert isSorted(as, 0, as.length - 1);
        show(as);
      }
    } else if (args[0].equals("long")) {
        String[] as = StdIn.readAllStrings();
        sort(as);
        assert isSorted(as, 0, as.length - 1);
        show(as);
    } else {
        String[] as = StdIn.readAllStrings();
        Integer[] ints = useInt(as);
        Stopwatch sw = new Stopwatch();
        sort(ints);
        System.out.println(sw.elapsedTime());
        assert isSorted(ints, 0, ints.length - 1);
        //show(ints);
    }
  }
}

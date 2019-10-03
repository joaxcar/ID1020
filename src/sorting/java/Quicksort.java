import edu.princeton.cs.algs4.Stopwatch;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.lang.reflect.Array;
import java.util.Random;

public class Quicksort{
  public static <T extends Comparable<? super T>> void sort(T[] a) {
    shuffleArray(a);;
    sort(a, 0, a.length -1);
  }

  private static  <T extends Comparable<? super T>> void shuffleArray(T[] array)
  {
    int index;
    T temp;
    Random random = new Random();
    for (int i = array.length - 1; i > 0; i--)
      {
        index = random.nextInt(i + 1);
        temp = array[index];
        array[index] = array[i];
        array[i] = temp;
      }
  }
  private static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi) {
    if (hi - lo < 10) {
      insertion(a, lo, hi);
      return;
    }
    if (lo >= hi) {
      return;
    }
    int cur = partition(a, lo, hi);
    sort(a, lo, cur - 1);
    sort(a, cur + 1, hi);
  }

  private static <T extends Comparable<? super T>> int partition(T[] a, int lo, int hi) {
    int cur = hi;
    int i = lo;
    int j = hi - 1;
    while (i <= j) {
      if (less(a[i], a[cur])) {
        i++;
      } else {
        exch(a, i, j);
        j--;
      }
    }
    exch(a, ++j, cur);
    return j;
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
      StdOut.println(a[i]);
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

  public static void main(String[] args)  throws IOException{
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
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
        String line = in.readLine();
        int size = Integer.parseInt(line);
        Integer[] ints = new Integer[size];
        for (int i = 0; i < size; i++) {
          line = in.readLine();
          if (line != null) {
            ints[i] = Integer.parseInt(line);
          }
        }
        sort(ints);
        assert isSorted(ints, 0, ints.length - 1);
        show(ints);
    }
  }
}

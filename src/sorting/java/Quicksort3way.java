import edu.princeton.cs.algs4.Stopwatch;
import java.util.Random;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.lang.reflect.Array;

public class Quicksort3way {
  public static <T extends Comparable<? super T>> void sort(T[] a) {
    shuffleArray(a);
    sort(a, 0, a.length -1);
  }

  private static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi) {
    if (hi - lo < 30){
      insertion(a, lo, hi);
      return;
    }
    if (lo >= hi) {
      return;
    }
    T cur = a[lo];
    int lt = lo;
    int i = lo;
    int gt = hi;
    while (i <= gt) {
      int cmp = a[i].compareTo(cur);
      if (cmp < 0) {
        exch(a, i, lt);
        lt++;
        i++;
      } else if (cmp > 0) {
        exch(a, i, gt);
        gt--;
      } else {
        i++;
      }
    }
    sort(a, lo, lt - 1);
    sort(a, gt + 1, hi);
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

  // Check if first argument is less than second
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

/** Shell.java
* Author: Johan Carlsson
* Created: 2019-09-14
* Edited: 2019-09-16
*
* Implementing shell sort
*/

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class ShellCount {

  /**
  * Sort generic array with shell sort
  */
  public static <T extends Comparable<? super T>> void sort(T[] a) {
    int swaps = 0;
    int g = 1;
    while (g < a.length/3) g = 3*g + 1; 

    while (g > 0) {
      for (int i = g; i < a.length; i += 1) {
        T cur = a[i];
        int j = i;
        while (j >= g && less(cur, a[j - g])) {
          System.out.println(g);
          swaps++;
          exch(a, j, j-g);
          show(a);
          j -= g;
        }
      }
      g = g/3;
    }

    System.out.println("Swaps: " + swaps);
  }

  // Check if first argument is less than second
  private static <T extends Comparable<? super T>> boolean less(T v, T w) {
    return v.compareTo(w) < 0;
  }

  // Exchange value at two indicies in array
  private static <T extends Comparable<? super T>>  void exch(T[] a, int i, int j) {
    T t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  /*
  * Print array to stdout
  */
  public static <T extends Comparable<? super T>> void show(T[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  /*
  * Check if array is sorted
  */
  public static <T extends Comparable<? super T>> boolean isSorted(T[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1])) return false;
    }
    return true;
  }

  // Parse array of strings to array of Integers
  private static Integer[] useInt(String[] strs) {
    int size = strs.length;
    Integer[] ints = new Integer[size];
    for (int i = 0; i < size; i++) {
      ints[i] = Integer.parseInt(strs[i]);
    }
    return ints;
  }

  /*
  * Main method used for testing, sorts lists of strings from stdin
  */
  public static void main(String[] args) {
    if (args[0].equals("short")) {
      while (StdIn.hasNextLine()) {
        String a = StdIn.readLine();
        String[] as = a.split(" ");
        sort(as);
        assert isSorted(as);
        show(as);
      }
    } else if (args[0].equals("long")) {
        String[] as = StdIn.readAllStrings();
        sort(as);
        assert isSorted(as);
        show(as);
    } else {
        String[] as = StdIn.readAllStrings();
        Integer[] ints = useInt(as);
        Stopwatch sw = new Stopwatch();
        sort(ints);
        System.out.println(sw.elapsedTime());
        assert isSorted(ints);
        //show(ints);
    }
  }
}

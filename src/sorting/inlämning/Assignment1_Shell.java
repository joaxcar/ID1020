/** Shell.java
* Author: Johan Carlsson
* Created: 2019-09-14
* Edited: 2019-09-16
*
* Implementing shell sort
* 
* Ex:
* In: 
* [ 1 2 4 3 5 0 ]
* Sort:
* [ 1 2 4 3 5 0 ]
* [ 1 2 4 3 5 0 ]
* [ 1 2 0 3 5 4 ]
* [ 1 2 0 3 5 4 ]
* [ 0 1 2 3 5 4 ]
* [ 0 1 2 3 5 4 ]
* [ 0 1 2 3 5 4 ]
* [ 0 1 2 3 4 5 ]
* [ 0 1 2 3 4 5 ]
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Shell {
  /**
  * Sort generic array with shell sort
  */
  public static <T extends Comparable<? super T>> void sort(T[] a) {
    for (int g = a.length / 2; g > 0; g /= 2) {
      for (int i = g; i < a.length; i += 1) {
        T cur = a[i];
        int j = i;
        while (j >= g && less(cur, a[j - g])) {
          a[j] = a[j-g];
          j -= g;
        }
        a[j] = cur;
        show(a);
      }
    }
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
    System.out.print("[ ");
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.print("]");
    System.out.println();
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
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
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
    show(ints);
  }
}

/** Shell.java
* Author: Johan Carlsson
* Created: 2019-09-14
* Edited: 2019-09-16
*
* Implementing shell sort, counting inversions
* In: [ 1 2 4 3 5 0 ]
* Out:
* [0, 1], [5, 0]
* [1, 2], [5, 0]
* [2, 4], [3, 3]
* [2, 4], [5, 0]
* [3, 3], [5, 0]
* [4, 5], [5, 0]
* Number of inversions: 6
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ShellInvesions {

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

  /**
  * Count and print all inversions in the array
  */
  public static <T extends Comparable<? super T>> int inversions(T[] a) {
    int invs = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = i; j < a.length; j++) {
        if (less(a[j], a[i])) {
          invs++;
          System.out.println("[" + i + ", " + a[i] + "], [" + j + ", " + a[j] + "]");
        }
      }
    }
    return invs;
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

/** ReversedSort.java
* Author: Johan Carlsson
* Created: 2019-09-14
* Edited: 2019-09-16
*
* Sorts an array in reversed order
* 
* Ex:
* In: 
* [ 1 2 4 3 5 0 ]
* Reverse:
* [ -1 -2 -4 -3 -5 0 ]
* Sort:
* [ -3 -2 -4 -1 -5 0 ]
* [ -3 -5 -4 -1 -2 0 ]
* [ -3 -5 -4 -1 -2 0 ]
* [ -5 -3 -4 -1 -2 0 ]
* [ -5 -4 -3 -1 -2 0 ]
* [ -5 -4 -3 -1 -2 0 ]
* [ -5 -4 -3 -2 -1 0 ]
* [ -5 -4 -3 -2 -1 0 ]
* Reverse:
* [ 5 4 3 2 1 0 ]
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ReversedSort {

  private static Integer[] useInt(String[] strs) {
    int size = strs.length;
    Integer[] ints = new Integer[size];
    for (int i = 0; i < size; i++) {
      ints[i] = Integer.parseInt(strs[i]);
    }
    return ints;
  }

  private static void rev(Integer[] ints) {
    for (int i = 0; i < ints.length; i++) {
      ints[i] = ints[i] * -1;
    }
  }

  public static void main(String[] args) {
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
      
      rev(ints);
      Shell.sort(ints);
      rev(ints);

      Shell.show(ints);
    }
  }
}

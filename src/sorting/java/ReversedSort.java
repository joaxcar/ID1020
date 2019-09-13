import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

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
    while (StdIn.hasNextLine()) {
      String a = StdIn.readLine();
      String[] as = a.split(" ");
      Integer[] ints = useInt(as);
      
      rev(ints);
      Shell.sort(ints);
      rev(ints);

      Shell.show(ints);
    }
  }
}

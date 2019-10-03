import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class SortTester {

  private static Integer[] useInt(String[] strs) {
    int size = strs.length;
    Integer[] ints = new Integer[size];
    for (int i = 0; i < size; i++) {
      ints[i] = Integer.parseInt(strs[i]);
    }
    return ints;
  }

  private static Integer[] readFile(String filename) {
    Integer[] ints = new Integer[1];
    try {
      BufferedReader in = new BufferedReader(new FileReader(filename));
      String line = in.readLine();
      int size = Integer.parseInt(line);
      ints = new Integer[size];
      for (int i = 0; i < size; i++) {
        line = in.readLine();
        if (line != null) {
          ints[i] = Integer.parseInt(line);
        }
      }
    }
    catch (IOException e) {
      System.out.println("file problem");
    }
    return ints;
  }

  public static void main(String[] args) {
    Integer[] list1 = readFile("/Users/ladmin/skola/kurser/kth-id1020/data/test1.txt");
    Integer[] list2 = readFile("/Users/ladmin/skola/kurser/kth-id1020/data/test2sorted.txt");
    Integer[] list3 = readFile("/Users/ladmin/skola/kurser/kth-id1020/data/test3.txt");
    int size = list1.length;
    System.out.println("Quicksort sort, sorting " + size + " unsorted ints in: ");
    for (int i = 0; i < 10; i++) {
      Integer[] listCopy = list1.clone();
      long startTime = System.currentTimeMillis();
      Quicksort.sort(listCopy);
      long endTime = System.currentTimeMillis();
      double elapsed = (endTime - startTime) / 1000.0;
      System.out.println(elapsed);
    }
    System.out.println("Quicksort sort, sorting " + size + " sorted ints in: ");
    for (int i = 0; i < 10; i++) {
      Integer[] listCopy = list2.clone();
      long startTime = System.currentTimeMillis();
      Quicksort.sort(listCopy);
      long endTime = System.currentTimeMillis();
      double elapsed = (endTime - startTime) / 1000.0;
      System.out.println(elapsed);
    }
    System.out.println("Quicksort sort, sorting " + size + " random with duplicates: ");
    for (int i = 0; i < 10; i++) {
      Integer[] listCopy = list3.clone();
      long startTime = System.currentTimeMillis();
      Quicksort3way.sort(listCopy);
      long endTime = System.currentTimeMillis();
      double elapsed = (endTime - startTime) / 1000.0;
      System.out.println(elapsed);
    }
    System.out.println("Mergesort sort, sorting " + size + " unsorted ints in: ");
    for (int i = 0; i < 10; i++) {
      Integer[] listCopy = list1.clone();
      long startTime = System.currentTimeMillis();
      Merge.sort(listCopy);
      long endTime = System.currentTimeMillis();
      double elapsed = (endTime - startTime) / 1000.0;
      System.out.println(elapsed);
    }
    System.out.println("Mergesort sort, sorting " + size + " sorted ints in: ");
    for (int i = 0; i < 10; i++) {
      Integer[] listCopy = list2.clone();
      long startTime = System.currentTimeMillis();
      Merge.sort(listCopy);
      long endTime = System.currentTimeMillis();
      double elapsed = (endTime - startTime) / 1000.0;
      System.out.println(elapsed);
    }
    System.out.println("Mergesort sort, sorting " + size + " random with duplicates: ");
    for (int i = 0; i < 10; i++) {
      Integer[] listCopy = list3.clone();
      long startTime = System.currentTimeMillis();
      Merge.sort(listCopy);
      long endTime = System.currentTimeMillis();
      double elapsed = (endTime - startTime) / 1000.0;
      System.out.println(elapsed);
    }
  }
}

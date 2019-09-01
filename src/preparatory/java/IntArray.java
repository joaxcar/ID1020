/*
  Johan Carlsson
  2019-08-26
  Program used to allocate and fill an array of integers based on input.
*/

import java.util.Scanner;

public class IntArray{

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    int nrElements = in.nextInt();
    int[] elements = new int[nrElements];

    for(int i = 0; i < nrElements; i++){
      elements[i] = in.nextInt();
    }

    in.close();

    for(int i = nrElements - 1; i >= 0; i--){
      System.out.println(elements[i]);
    }
  }
}

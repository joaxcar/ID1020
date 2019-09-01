/*
  Written by: Johan Carlsson
  Created: 2019-08-26
  Edited: 2019-09-01

  "IntArray" creates an array of ints and prints it to stdout in opposite order.

  The first int read from stdin is used to initiate the array to the given length.
  Subsequent ints are placed in the array and then printed to stdout last to first.
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

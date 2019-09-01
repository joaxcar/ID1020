/*
  Written by: Johan Carlsson
  Created: 2019-08-26
  Edited: 2019-09-01

  "intarray" creates an array of ints and prints it to stdout in opposite order.

  The first int read from stdin is used to initiate the array to the given length.
  Subsequent ints are placed in the array and then printed to stdout last to first.
*/

#include <stdio.h>
#include <stdlib.h>

int main(void){
  int arraySize;
  int *numbers;

  // Get size and allocate memmory
  scanf("%d", &arraySize);
  numbers = (int*) malloc(sizeof(int)*arraySize);

  // Read number of integers
  for (int i = 0; i < arraySize; i++){
    scanf("%d", numbers + i);
  }

  // Print integers in oposite order
  for (int i = arraySize -1; i >= 0; i--){
    printf("%d\n", *(numbers + i));
  }

  free(numbers);
}



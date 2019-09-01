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



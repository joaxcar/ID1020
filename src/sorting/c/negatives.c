/*
* negatives.c
* Author: Johan Carlsson
* Created: 2019-09-13
*
* When executed the program reads one integer value from stdin to alocate an
* array of ints of that size. Then it reads a series of ints from stdin to
* fill the array. When the array is full it gets ordered so that all negative
* values comes first.
*/

#include <stdio.h>
#include <stdlib.h>

/*
* Order a list so that all negative values comes first
*/
void order(int* list, int size) {
  int i;
  int j = 0;
  int t;

  // Loop through the list, move negatives to j-th position and increment j
  for (i = 0; i < size; i++) {
   if (list[i] < 0) {
    t = list[i];
    list[i] = list[j];
    list[j] = t;
    j++;
   }
  }
}

/*
* Main method reading integers from stdin then reorders the array
*/
int main() {
  int size;
  int* list;

  scanf("%d", &size);
  list = (int*) malloc(sizeof(int) * size);

  for (int i = 0; i < size; i++) {
    scanf("%d", (list + i));
  }

  order(list, size);
  
  for (int i = 0; i < size; i++) {
    printf("%d ", *(list + i));
  }
  
  printf("\n");

  free(list);
}


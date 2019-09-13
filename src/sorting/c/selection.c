#include <stdio.h>

void sort(int* a, int size) {
  int  min = 0;
  for (int i = 0; i < size; i++) {
    for (int j = i + 1; j < size; j++) {
      if ( a[j] < a[min]) {
        min = j;
      }
    }
    int t = a[min];
    a[min] = a[i];
    a[i] = t;
  }
}

int main() {
  int a[50000];
  for (int i = 0; i < 50000; i++) {
    scanf("%d", &a[i]);
  }
  sort(a, sizeof(a)/sizeof(a[0]));
  for (int i = 0; i < 50000; i++) {
    printf("%d\n", a[i]);
  }
}

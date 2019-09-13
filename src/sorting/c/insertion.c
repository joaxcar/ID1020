#include <stdio.h>

void sort(int* a, int size) {
  int cur;
  int j;
  for (int i = 1; i < size; i++) {
    cur = a[i];
    j = i - 1;
    while (j > -1 && a[j] > cur) {
      a[j + 1] = a[j];
      j--;
    }
    a[j + 1] = cur;
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

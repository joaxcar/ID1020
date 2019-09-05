#include <stdio.h>
#include <stdlib.h>

void readwriteRec();
void readwriteIt();

int main() {
  readwriteRec();
  putchar('\n');
  readwriteIt();
  putchar('\n');
  return 0;
}

void readwriteRec() {
  char c = getchar();
  if (c != '\n') {
    readwriteRec();
    putchar(c);
  }
  return;
}

/* Read from stdin and print to stdout reversed iteratively */
void readwriteIt() {
  int index = 0;
  char* chars = (char*) malloc(sizeof(char)*100);

  *chars = getchar();
  while (*(chars + index) != '\n') {
    index++;
    *(chars + index) = getchar();
  }

  while (index >= 0) {
    index--;
    putchar(*(chars + index));
  }

  free(chars);

  return;
}


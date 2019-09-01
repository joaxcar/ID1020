/*
*  afilter reads a stream of chars and prints them to stout.
*  Replacing every encountered "a" with "X". The program ends at EOF
*/

#include <stdio.h>

int main(void){
  char curChar;

  while(1){
    curChar = getchar();
    if(curChar == EOF){
      break;
    } else if (curChar == 'a'){
      curChar = 'X';
    }
    putchar(curChar);
  } 

}

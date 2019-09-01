/*
*  Written by: Johan Carlsson
*  Created: 2019-08-27
*  Edited: 2019-09-01
*
*  "afilter" reads a stream of chars from stdin and prints them to stout.
*  Replacing every encountered "a" with "X". The program ends at EOF
*
*  You can either run the program and enter input manualy, ending by sending an EOF (Ctrl-d on most
*  Linux systems). Or pipe in a text from a file.
*/

#include <stdio.h>

/* Entry point of the program */
int main(void){
  char curChar;

  // Infinite loop checking for chars, breaks at EOF
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

/*
 * SingleLinkedList.java
 * Johan Carlsson
 * Created: 2019-08-28
 * 
 * Class implements a single linked list as a FIFO with possibility to use as priority que
*/

import java.util.Scanner;

public class SingleLinkedList{
  /* Node structure */
  private class Node{
    Node next;
    int value;

    Node(int value){
      this.value = value;
    }
  }

  Node head;

  // Create new instance of SingleLinkedList
  public SingleLinkedList(){
  }

  // Push a value onto the stack
  public void push(int value){
    Node newNode = new Node(value);
    newNode.next = head;
    head = newNode;
  }

  // Push a value into the stack before the first lower value
  public void pushSorted(int value){
    if(head == null){
      push(value);
    }
    else if(value > head.value){
      push(value);
    }else{
      Node curNode = head;
      while(curNode != null){
        if(curNode.next == null){
          insert(new Node(value), curNode);
          break;
        }
        if(curNode.next.value < value){
          insert(new Node(value), curNode);
          break;
        }
        curNode = curNode.next;
      }
    }
  }

  // Place Node after a target Node
  private void insert(Node toPlace, Node after){
    toPlace.next = after.next;
    after.next = toPlace;
  }

  // Check if stack is empty
  public boolean hasNext(){
    return head != null;
  }

  // Pop a value of the stack
  public int pop(){
      int value = head.value;
      head = head.next;
      return value;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    Node curNode = head;
    while (curNode != null){
      sb.append(curNode.value);
      sb.append(" ");
      curNode = curNode.next;
    }
    return sb.toString();
  }

  /*
     Main method that takes ints on Stdin and pushes them on the stack.
     When all ints are read, it prints the sack and pops all items
  */
  public static void main(String[] args){
    SingleLinkedList list = new SingleLinkedList();
    Scanner in = new Scanner(System.in);
    while(in.hasNextInt()){
      list.pushSorted(in.nextInt());
    }
    System.out.println(list);
    while(list.hasNext()){
      System.out.println(list.pop());
    }
  }
}

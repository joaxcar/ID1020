/*
 * SingleLinkedList.java
 * Johan Carlsson
 * Created: 2019-08-28
 * Edited: 2019-09-01
 * 
 * "SingleLinkedList" implements a single linked list working as a stack storing integer values.
 * A client can "push" values onto the top of the stack with the method push, and "pop" the top
 * value of the stack with the method pop.
 * The class can be used as a simple priority queue by using the method pushSorted instead of push.
 * The list can be represented as a String by invoking toSting.
 * Use the method hasNext to check if there are values in the list.
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

  // Pop a value of the stack
  public int pop(){
      int value = head.value;
      head = head.next;
      return value;
  }

  // Check if stack is empty
  public boolean hasNext(){
    return head != null;
  }

  // Push a value into the stack before the first lower value
  public void pushSorted(int value){
    // Make value head if list is empty
    if(head == null){
      push(value);
    }
    else if(value > head.value){
      push(value);
    }else{
      // Step through the list to find a lower value, if no lower value is found put it last
      Node curNode = head;
      while(curNode != null){
        // Check if last value
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

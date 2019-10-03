/*
 * SimplePriorityQueue.java
 * Johan Carlsson
 * Created: 2019-08-30
 * 
 * Class implements a priority queue by placing items in place at insertion
*/

import java.util.Scanner;

public class SimplePriorityQueue{

  Node head;

  /* Node structure */
  private class Node{
    Node next;
    int value;
  }

  // Create new instance of SingleLinkedList
  public SimplePriorityQueue(){
  }

  // Push a value into the queue before the first lower value
  public void push(int value){
    Node newNode = new Node();
    newNode.value = value;
    Node cur = head;

    if (cur == null || cur.value > value) {
      makehead(newNode);
      return;
    }

    while (cur.next != null && cur.next.value < newNode.value) {
      cur = cur.next;
    }

    insert(newNode, cur);
  }

  // make node new head
  private void makehead(Node newHead) {
    newHead.next = head;
    head = newHead;
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

  // Return the stack as a String
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
    SimplePriorityQueue list = new SimplePriorityQueue();
    Scanner in = new Scanner(System.in);
    while(in.hasNextInt()){
      list.push(in.nextInt());
      System.out.println(list);
    }
    while(list.hasNext()){
      System.out.println(list.pop());
      System.out.println(list);
    }
  }
}

/*
 * CircularList.java
 * Johan Carlsson
 * Created: 2019-08-30
 * Edited: 2019-09-01
 * 
 * "CircularList" implements a circular list storing integer value swith a base element with value -1.
 * The list stores the values sorted in descending order.
 * Use push to add a value to the list
 * Use pop to pop the first element of the list
*/

import java.util.Scanner;

public class CircularList{
  /* Node structure */
  private class Node{
    Node next;
    Node prev;
    int value;

    Node(int value){
      this.value = value;
    }
  }

  Node head;

  // Create new instance of SingleLinkedList
  public CircularList(){
    head = new Node(-1);
    head.next = head;
    head.prev = head;
  }

  // Push a value into the stack before the first lower value
  public void push(int value){
    Node curNode = head.next;
    while(curNode != head){
      if(curNode.value > value){
        break;
      }
      curNode = curNode.next;
    }
    insert(new Node(value), curNode.prev);
  }
  
  // Place Node after a target Node
  private void insert(Node toPlace, Node after){
    toPlace.next = after.next;
    after.next = toPlace;
    toPlace.prev = after;
    toPlace.next.prev = toPlace;
  }

  // Pop a value of the stack
  public int pop(){
      int value = head.next.value;
      remove(head.next);
      return value;
  }

  // Check if stack is empty
  public boolean hasNext(){
    return head.next != head;
  }

  public Node remove(Node target){
    Node curNode = head.next;
    while(curNode != target){ 
      curNode = curNode.next;
    }
    curNode.prev.next = curNode.next;
    curNode.next.prev = curNode.prev;
    curNode.next = curNode;
    curNode.prev = curNode;
    return curNode;
  }

  // Return the list as a String
  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    Node curNode = head.next;
    while (curNode != head){
      sb.append(curNode.value);
      sb.append(" ");
      curNode = curNode.next;
    }
    return sb.toString();
  }

  /*
     Main method that takes ints on Stdin and pushes them to the ring
     When all ints are read, it prints the sack and pops all items
  */
  public static void main(String[] args){
    CircularList list = new CircularList();
    Scanner in = new Scanner(System.in);
    while(in.hasNextInt()){
      list.push(in.nextInt());
      System.out.println(list);
    }
    while(list.hasNext()){
      System.out.println(list.pop());
      System.out.println(list);
    }

    if(args != null && args[0].equals("test")){
      assert(list.pop() == -1); // list should be empty
      list.push(2);
      list.push(22);
      list.push(3);
      list.push(1);
      assert(list.toString().equals("1 2 3 22 ")); // list should be sorted
      list.push(-5);
      list.push(-1);
      assert(list.toString().equals("-5 -1 1 2 3 22 ")); // list should be sorted
      assert(list.pop() == -5); // can pop negative numbers
      assert(list.pop() == -1); // can pop a -1
      list.pop();
      list.pop();
      list.pop();
      list.pop();
      assert(list.pop() == -1); // list empty
      assert(list.pop() == -1); // list empty
    }

  }
}

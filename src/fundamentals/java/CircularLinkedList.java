/**
* CircularLinkedList.java
* Author: Johan Carlsson
* Created: 2019-09-08
*
* Implements a circular linked list structure.
*/

import java.util.Scanner;
import java.util.Iterator;

public class CircularLinkedList<Item> implements Iterable {
  int size;
  Node head;

  // Node structure
  private class Node {
    Node next;
    Item item;
  }

  /**
  * Create a new instance of CircularLinkedList
  */
  public CircularLinkedList() {
    head = new Node();
    head.next = head;
    size = 0;
  }

  /**
  * Add an item to the end of the list
  */
  public void prepend(Item item) {
    Node newNode = new Node();
    newNode.item = item;
    newNode.next = head.next;
    head.next = newNode;
    size++;
  }

  /**
  * Add an item to the front of the list
  */
  public void append(Item item) {
    Node newNode = new Node();
    newNode.item = item;
    Node lastNode = findNode(size);
    newNode.next = head;
    lastNode.next = newNode;
    size++;
  }

  // get Node at index
  private Node findNode(int index) {
    if (index > size && index < 0) {
      return head;
    }
    Node curNode = head;
    for (int i = 0; i < index; i++) {
      curNode = curNode.next;
    }
    return curNode;
  }

  /**
  * Get first item in the list
  */
  public Item getFirst() {
    Node removed = head.next;
    head.next = removed.next;
    removed.next = null;
    size--;
    return removed.item;
  }

  /**
  * Get last item in the list
  */
  public Item getLast() {
    Node nextToLast = findNode(size-1);
    Node removed = nextToLast.next;
    nextToLast.next = head;
    removed.next = null;
    size--;
    return removed.item;
  }

  /**
  * Get size of list
  */
  public int size() {
    return size;
  }

  /**
  * Check if list is empty
  */
  public boolean isEmpty() {
    return head.next == head;
  }

  @Override
  public Iterator<Item> iterator() {
    return new CircularListIterator();
  }

  // Implementation of iterator over circular list
  private class CircularListIterator implements Iterator<Item> {
    Node curNode;
    public CircularListIterator() {
      curNode = head.next;
    }
    public boolean hasNext() {
      return curNode != head;
    }
    public Item next() {
      Item retItem = curNode.item;
      curNode = curNode.next;
      return retItem;
    }
    public void remove() { /* not implemented */ }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    Node curNode = head.next;
    while (curNode != head){
      sb.append(curNode.item);
      sb.append(", ");
      curNode = curNode.next;
    }
    sb.append("]");
    return sb.toString();
  }

  /**
  * Main method used for testing of GeneralizedQueue ADT
  */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in, "utf-8");
    CircularLinkedList<String> q = new CircularLinkedList<String>();
    while (sc.hasNext()) {
      q.append(sc.next());
      System.out.println("Elements in queue:\t\t\t" + q);
      System.out.println("Number of elements in queue:\t\t" + q.size());
    }
    while (! q.isEmpty()) {
      System.out.println("Returned element from queue:\t\t" + q.getFirst());
      System.out.println("Elements in queue:\t\t\t" + q);
      System.out.println("Number of elements in queue:\t\t" + q.size());
    }

    sc = new Scanner(System.in, "utf-8");
    while (sc.hasNext()) {
      q.prepend(sc.next());
      System.out.println("Elements in queue:\t\t\t" + q);
      System.out.println("Number of elements in queue:\t\t" + q.size());
    }
    while (! q.isEmpty()) {
      System.out.println("Returned element from queue:\t\t" + q.getLast());
      System.out.println("Elements in queue:\t\t\t" + q);
      System.out.println("Number of elements in queue:\t\t" + q.size());
    }
  }
}

/**
* GeneralizedQueue.java
* Author: Johan Carlsson
* Created: 2019-09-04
* Edited: 2019-08-09
*
* The ADT GeneralizedQueue implements a generalized queue with the API:
* prepend, put element in head of queue
* insert, put element in tail of queue
* remove, remove element at index
* size, returns number of elements in queue
* isEmpty, returns true if empty
*
* The ADT also implements Iterable and provides an iterator to iterate through the queue head to tails.
*/

import java.util.Iterator;
import java.util.Scanner;

public class GeneralizedQueue<Item> implements Iterable<Item> {

  Node head;
  Node tail;
  int size;

  // Node structure
  private class Node {
    Node next;
    Node prev;
    Item item;
  }

  /**
  * Create new instance of Queue
  */
  public GeneralizedQueue() {
    size = 0;
  }

  /**
  * Puts element in tail position in the queue
  */
  public void insert(Item item) {
    Node newNode = new Node();
    newNode.item = item;
    if (isEmpty()) {
      head = newNode;
      tail = newNode;
    }
    else {
      newNode.next = tail;
      tail.prev = newNode;
      tail = newNode;
    }
    size++;
  }

  /**
  * Remove element in queue at given index
  */
  public Item remove(int index) {
    Node node = getNode(index);
    Item returnItem = node.item;
    remove(node);
    return returnItem;
  }

  // Get node at index in queue
  private Node getNode(int index) {
    if (index > this.size()) {
      throw new IndexOutOfBoundsException();
    }
    Node curNode = tail;
    for (int i = 1; i < index; i++) {
      curNode = curNode.next;
    }
    return curNode;
  }

  // Remove a node from the queue
  private void remove(Node node) {
    if (node.next != null) {
      node.next.prev = node.prev;
    }
    if (node.prev != null) {
      node.prev.next = node.next;
    }
    node.prev = null;
    node.next = null;
    size--;
  }

  /**
  * Returns number of elements in queue
  */
  public int size() {
    return size;
  }

  /**
  * Check if queue is empty
  */
  public boolean isEmpty() {
    return head == null;
  }

  /**
  * Create new iterator over queue
  */
  @Override
  public Iterator<Item> iterator() {
    return new queueIterator();
  }

  // Implementation of iterator on queue ADT
  private class queueIterator implements Iterator<Item> {
    Node curNode;

    public queueIterator() {
      curNode = head;
    }

    @Override
    public boolean hasNext() {
      return curNode != null;
    }
  
    @Override
    public Item next() {
      Item returnItem = curNode.item;
      curNode = curNode.prev;
      return returnItem;
    }

    @Override
    public void remove() { /* not implemented */ }
  }

  /**
  * Get queue as a String
  */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    Node curNode = head;
    while (curNode != null){
      sb.append(curNode.item);
      if (curNode.prev != null) {
      sb.append(", ");
      }
      curNode = curNode.prev;
    }
    sb.append("]");
    return sb.toString();
  }

  /**
  * Main method used for testing of GeneralizedQueue ADT
  */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in, "utf-8");
    GeneralizedQueue<String> q = new GeneralizedQueue<String>();
    while (sc.hasNext()) {
      q.insert(sc.next());
      System.out.println("Elements in queue:\t\t\t" + q);
      System.out.println("Number of elements in queue:\t\t" + q.size());
    }
    while (! q.isEmpty()) {
      System.out.println("Returned element from queue:\t\t" + q.remove(1));
      q.remove(1);
      System.out.println("Elements in queue:\t\t\t" + q);
      System.out.println("Number of elements in queue:\t\t" + q.size());
    }

    // Tests for Queue
    GeneralizedQueue<String> testq = new GeneralizedQueue<String>();
    assert(testq.isEmpty() == true);
    assert(testq.size() == 0);
    testq.insert("test1");
    assert(testq.toString().equals("[test1]"));
    assert(testq.isEmpty() == false);
    assert(testq.size() == 1);
    testq.insert("test2");
    assert(testq.toString().equals("[test1, test2]"));
    assert(testq.isEmpty() == false);
    assert(testq.size() == 2);
    testq.insert("test3");
    assert(testq.toString().equals("[test1, test2, test3]"));
    assert(testq.isEmpty() == false);
    assert(testq.size() == 3);
    assert(testq.remove(1).equals("test1"));
    assert(testq.toString().equals("[test2, test3]"));
    assert(testq.isEmpty() == false);
    assert(testq.size() == 2);
    testq.insert("test1");
    assert(testq.toString().equals("[test2, test3, test1]"));
    assert(testq.isEmpty() == false);
    assert(testq.size() == 3);
    assert(testq.remove(1).equals("test2"));
    assert(testq.toString().equals("[test3, test1]"));
    assert(testq.isEmpty() == false);
    assert(testq.size() == 2);
    assert(testq.remove(1).equals("test3"));
    assert(testq.toString().equals("[test1]"));
    assert(testq.isEmpty() == false);
    assert(testq.size() == 1);
    assert(testq.remove(1).equals("test1"));
    assert(testq.toString().equals("[]"));
    assert(testq.isEmpty() == true);
    assert(testq.size() == 0);
  }
}

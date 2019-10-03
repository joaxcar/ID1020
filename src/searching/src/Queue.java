/**
* Queue.java
* Author: Johan Carlsson
* Created: 2019-09-04
* Edited: 2019-08-09
*
* The ADT Queue implements a FIFO queue with the API:
* enqueue, put element in tail of queue
* dequeue, get element from head of queue
* size, returns number of elements in queue
* isEmpty, returns true if empty
*
* The ADT also implements Iterable and provides an iterator to iterate through the queue head to tails.
*/

import java.util.Iterator;
import java.util.Scanner;

public class Queue<Item> implements Iterable<Item> {

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
  public Queue() {
    size = 0;
  }

  /**
  * Puts element in tail position in the queue
  */
  public void enqueue(Item item) {
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
  * Returns element at head position of queue and removes element from queue
  */
  public Item dequeue() {
    Item returnItem = head.item;
    Node newHead = head.prev;
    head.prev = null;
    head.next = null;
    head = newHead;
    size--;
    return returnItem;
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
  * Main method used for testing of Queue ADT
  */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in, "utf-8");
    Queue<String> q = new Queue<String>();
    while (sc.hasNext()) {
      q.enqueue(sc.next());
      System.out.println("Elements in queue:\t\t\t" + q);
      System.out.println("Number of elements in queue:\t\t" + q.size());
    }
    while (! q.isEmpty()) {
      System.out.println("Returned element from queue:\t\t" + q.dequeue());
      System.out.println("Elements in queue:\t\t\t" + q);
      System.out.println("Number of elements in queue:\t\t" + q.size());
    }

    // Tests for Queue
    Queue<String> testq = new Queue<String>();
    assert(testq.isEmpty() == true);
    assert(testq.size() == 0);
    testq.enqueue("test1");
    assert(testq.toString().equals("[test1]"));
    assert(testq.isEmpty() == false);
    assert(testq.size() == 1);
    testq.enqueue("test2");
    assert(testq.toString().equals("[test1, test2]"));
    assert(testq.isEmpty() == false);
    assert(testq.size() == 2);
    testq.enqueue("test3");
    assert(testq.toString().equals("[test1, test2, test3]"));
    assert(testq.isEmpty() == false);
    assert(testq.size() == 3);
    assert(testq.dequeue().equals("test1"));
    assert(testq.toString().equals("[test2, test3]"));
    assert(testq.isEmpty() == false);
    assert(testq.size() == 2);
    testq.enqueue("test1");
    assert(testq.toString().equals("[test2, test3, test1]"));
    assert(testq.isEmpty() == false);
    assert(testq.size() == 3);
    assert(testq.dequeue().equals("test2"));
    assert(testq.toString().equals("[test3, test1]"));
    assert(testq.isEmpty() == false);
    assert(testq.size() == 2);
    assert(testq.dequeue().equals("test3"));
    assert(testq.toString().equals("[test1]"));
    assert(testq.isEmpty() == false);
    assert(testq.size() == 1);
    assert(testq.dequeue().equals("test1"));
    assert(testq.toString().equals("[]"));
    assert(testq.isEmpty() == true);
    assert(testq.size() == 0);
  }
}

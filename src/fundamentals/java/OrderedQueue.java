/**
* OrderedQueue.java
* Author: Johan Carlsson
* Created: 2019-09-08
*
* OrderedQueue implements an ordered queue
* Two CircularLinkedLists are used for the sorting. 
*
* API:
* add, add an int to the queue in ascending order
* dequeue, get first element in queue
* size, get size of queue
* toString, get queue as a String
* iterator, get an iterator over the queue
*/

import java.util.Scanner;
import java.util.Iterator;

public class OrderedQueue implements Iterable {
  CircularLinkedList<Integer> valueQ = new CircularLinkedList<Integer>(); 
  CircularLinkedList<Integer> tempQ = new CircularLinkedList<Integer>(); 

  /**
  * Create new OrderedQueue object
  */
  public OrderedQueue() { }

  /**
  * Add item to queue, will be placed in ascending order
  */
  public void add(int item){
    if (valueQ.isEmpty()) {
      valueQ.append(item);
    }
    // If not empty move larger values to tempQ
    else {
      while (!(valueQ.isEmpty())) {
        int curItem = valueQ.getLast();
        if (curItem > item) {
          tempQ.append(curItem);
        } else {
          valueQ.append(curItem);
          break;
        }
      }
      // Place value in place
      valueQ.append(item);
      // Move rest of queue back from tempQ
      while (!tempQ.isEmpty()) {
        valueQ.append(tempQ.getLast());
      }
    }
  }

  /**
  * Get value from front of queue
  */
  public int dequeue() {
    return valueQ.getFirst();
  }

  /**
  * Get size of queue
  */
  public int size() {
    return valueQ.size();
  }

  /**
  * Check if queue is empty
  */
  public boolean isEmpty() {
    return valueQ.isEmpty();
  }

  /**
  * Get an iterator over queue
  */
  @Override
  public Iterator<Integer> iterator() {
    return valueQ.iterator();
  }

  /**
  * Get queue as a string
  */
  @Override
  public String toString() {
    return valueQ.toString();
  }

  /**
  * Main method used for testing of GeneralizedQueue ADT
  */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in, "utf-8");
    OrderedQueue q = new OrderedQueue();
    while (sc.hasNextInt()) {
      q.add(sc.nextInt());
      System.out.println("Elements in queue:\t\t\t" + q);
    }
    while (! q.isEmpty()) {
      System.out.println("Returned element from queue:\t\t" + q.dequeue());
      System.out.println("Elements in queue:\t\t\t" + q);
    }
  }
}

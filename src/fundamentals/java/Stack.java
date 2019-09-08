/**
* Stack.java
* 
* Author: Johan Carlsson
* Created: 2019-09-03
* 
* Implements a generic stack with the standard API as a linked list
* API: push, pop, isEmpty and size
* The stack is also iterable.
*/

import java.util.Iterator;

/**
* Class stack implementing iterable.
*/
public class Stack<Item> implements Iterable<Item> {

  // Linked list structure
  private class Node {
    Node next;
    Item item;
  }

  private Node head;
  private int size;

  /**
  * Initiates a new Stack object
  */
  public Stack() {
    size = 0;
  }

  /**
  * Push an <code>Item</code> on to the stack
  */
  public void push(final Item item) {
    Node newNode = new Node();
    newNode.item = item;
    newNode.next = head;
    head = newNode;
    size++;
  }

  /**
  * Pops an <code>Item</code> from the stack. Always check if stack is empty before pop!
  */
  public Item pop() {
    final Item item = head.item;
    head = head.next;
    size--;
    return item;
  }

  /**
  * Check if stack is empty, do this before call to pop
  */
  public boolean isEmpty() {
    return head == null;
  }

  /**
  * Get the current size of the stack
  */
  public int size() {
    return size;
  }

  /**
  * Get an iterator to list elements in the stack
  */
  public Iterator<Item> iterator() {
    return new StackIterator();
  }

  // Stack iterator implementation
  private class StackIterator implements Iterator<Item> {
    private Node curNode = head;
    private final int  sizeAtInitiation = size;

    public boolean hasNext () {
      return curNode != null;
    }

    public Item next() {
      final Item item = curNode.item;
      curNode = curNode.next;
      return item;
    }

    public void remove() { /* not in use */ }
  }

  /**
  * Main method used for testing. Run with -ea flag
  */
  public static void main(String[] args) {
    Stack<String> s = new Stack<String>();
    assert(s.size() == 0);
    assert(s.isEmpty() == true);
    s.push(new String("TEST"));
    assert(s.size() == 1);
    assert(s.isEmpty() == false);
    String t = s.pop();
    assert(t.equals("TEST"));
    assert(s.size() == 0);
    assert(s.isEmpty() == true);
    s.push(new String("TEST1"));
    s.push(new String("TEST2"));
    s.push(new String("TEST3"));
    assert(s.size() == 3);
    assert(s.isEmpty() == false);
    t = s.pop();
    assert(t.equals("TEST3"));
    t = s.pop();
    assert(t.equals("TEST2"));
    t = s.pop();
    assert(t.equals("TEST1"));
    s.push(new String("TEST1"));
    s.push(new String("TEST2"));
    s.push(new String("TEST3"));
    for (String str : s) {
      System.out.println(str);
    }
  }
}

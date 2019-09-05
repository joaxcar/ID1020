import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

  Node head;
  Node tail;
  int size;

  private class Node {
    Node next;
    Node prev;
    Item item;
  }

  public Queue() {
    size = 0;
  }

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

  public Item dequeue() {
    Item returnItem = head.item;
    Node newHead = head.prev;
    head.prev = null;
    head.next = null;
    head = newHead;
    size--;
    return returnItem;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public Iterator<Item> iterator() {
    return new queueIterator();
  }

  private class queueIterator implements Iterator<Item> {
    Node curNode;

    public queueIterator() {
      curNode = head;
    }

    public boolean hasNext() {
      return curNode != null;
    }

    public Item next() {
      Item returnItem = curNode.item;
      curNode = curNode.prev;
      return returnItem;
    }

    public void remove() { /* not implemented */ }
  }

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

  public static void main(String[] args) {
    Queue<String> q = new Queue<String>();
    q.enqueue("ett");
    System.out.println(q);
    q.enqueue("två");
    System.out.println(q);
    q.enqueue("tre");
    System.out.println(q);
    q.enqueue("fyra");
    System.out.println(q);
    q.dequeue();
    System.out.println(q);
    q.dequeue();
    System.out.println(q);
    q.dequeue();
    System.out.println(q);
    q.dequeue();
    System.out.println(q);
    Queue<Integer> q2 = new Queue<Integer>();
    q2.enqueue(1);
    System.out.println(q2);
    q2.enqueue(2);
    System.out.println(q2);
    q2.enqueue(3);
    System.out.println(q2);
    q2.enqueue(4);
    System.out.println(q2);
    q2.dequeue();
    System.out.println(q2);
    q2.dequeue();
    System.out.println(q2);
    q2.dequeue();
    System.out.println(q2);
    q2.dequeue();
    System.out.println(q);
  }
}

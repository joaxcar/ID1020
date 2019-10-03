import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    Node root;
    int size = 0;

    private class Node {
        Node next;
        Item item;
    }

    public Bag() { }

    public void add(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = root;
        root = newNode;
        size++;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(Item item) {
        for (Item inBag : this) {
            if (item.equals(inBag)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item> {
        Node cur = root;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Item next() {
            Item ret = cur.item;
            cur = cur.next;
            return ret;
        }

        @Override
        public void remove() {
            /* Not implemented */
        }
    }
}

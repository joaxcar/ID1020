import java.util.NoSuchElementException;

public class BST<Key extends Comparable<? super Key>, Value>{
    private Node root;

    private int size;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;

        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    }

    public BST() {
        size = 0;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        size++;
    }

    private Node put(Node x, Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (x == null) {
            return new Node(key, val);
        }
        int comp = key.compareTo(x.key);
        if (comp < 0) {
            x.left = put(x.left, key, val);
        }
        else if (comp > 0) {
            x.right = put(x.right, key, val);
        }
        else {
            x.value = val;
        }
        return x;
    }

    public Value get(Key key) {
        Node ret = get(root, key);
        return ret.value;
    }

    public int size() {
        return size;
    }
    public boolean contains(Key key) {
       Node found = get(root, key);
       return found != null;
    }

    private Node get(Node x, Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (x == null) {
            return null;
        }
        int comp = key.compareTo(x.key);
        if (comp < 0) {
            return get(x.left, key);
        }
        else if (comp > 0) {
            return get(x.right, key);
        }
        else {
            return x;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls max() with empty symbol table");
        }
        return max(root).key;
    }

    private Node max(Node n) {
        if (n.right == null) {
            return n;
        }
        else {
            return max(n.right);
        }
    }

    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls min() with empty symbol table");
        }
        return min(root).key;
    }

    private Node min(Node n) {
        if (n.left == null) {
            return n;
        }
        else {
            return min(n.left);
        }
    }

    public Iterable<Key> keys() {
        if (isEmpty()) {
            return new Queue<Key>();
        }
        return keys(min(), max());
    }

    private Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) {
            throw new IllegalArgumentException("lo does not contain a value");
        }
        if (hi == null) {
            throw new IllegalArgumentException("hi does not contain a value");
        }
        Queue<Key> qu = new Queue<Key>();

        keys(root, qu, lo, hi);
        return qu;
    }

    private void keys(Node x, Queue<Key> qu, Key lo, Key hi) {
       if (x == null) {
           return;
       }

       int complo = lo.compareTo(x.key);
       int comphi = hi.compareTo(x.key);

       if (complo < 0) {
           keys(x.left, qu, lo, hi);
       }
       if (complo <= 0 && comphi >= 0) {
           qu.enqueue(x.key);
       }
       if (comphi > 0) {
           keys(x.right, qu, lo, hi);
       }
    }

}

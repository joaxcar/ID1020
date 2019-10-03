public class ArrayST <Key extends Comparable <? super Key>, Value> {
    private final static int SIZE = 1;
    private Key[] keys;
    private Value[] vals;
    private int i;

    public ArrayST() {
        keys = (Key[]) new Comparable[SIZE];
        vals = (Value[]) new Object[SIZE];
        i = 0;
    }

    public void  put(Key key, Value val) {
        int index = rank(key);
        if (index < i && keys[index].compareTo(key) == 0) {
            vals[index] = val;
            return;
        }

        if (i >= keys.length) {
            resize();
        }

        for (int j = i; j > index; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[index] = key;
        vals[index] = val;
        i++;
    }
    public Value  get(Key key) {
        int index = rank(key);
        Key atIndex = keys[index];
        if (atIndex.compareTo(key) != 0) {
            return null;
        }
        return vals[index];
    }
    // public boolean  contains(Key key)
    // public void  delete(Key key)
    public boolean  isEmpty() {
        return i == 0;
    }

    public boolean contains(Key key) {
        if (i == 0) {
            return false;
        }
        int index = rank(key);
        if (index >= i) {
            return false;
        }
        return keys[index].compareTo(key) == 0;
    }

    public void delete(Key key) {
        int index = rank(key);
        if (keys[index].compareTo(key) == 0) {
            for (int i = index; i < this.i; i++) {
                keys[i] = keys[i + 1];
                vals[i] = vals[i + 1];
            }
            i--;
        }
    }

    public Key max() {
        return keys[i - 1];
    }

    public Key min() {
        return keys[0];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Key k : keys) {
            sb.append(k);
            sb.append(" ");
        }
        return sb.toString();
    }


    public Iterable<Key> keys() {
        Queue<Key> qu = new Queue<>();
        for (Key k : keys) {
            if (k != null) {
                qu.enqueue(k);
            }
        }
        return qu;
    }

    //public int   size()
    //public Iterable<Key> keys()
    private int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        int lo = 0;
        int hi = i - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            int comp = key.compareTo(keys[mid]);
            if (comp < 0) {
                 hi = mid - 1;
            }
            else if (comp > 0) {
                lo = mid + 1;
            }
            else {
                return mid;
            }
        }
        return lo;
    }

    private void resize() {
        Key[] newKeys;
        Value[] newVals;
        if (i > keys.length / 2) {
            newKeys = (Key[]) new Comparable[keys.length * 2];
            newVals = (Value[]) new Object[keys.length * 2];
            System.arraycopy(keys, 0, newKeys, 0, keys.length);
            System.arraycopy(vals, 0, newVals, 0, vals.length);
        }
        else {
            newKeys = (Key[]) new Comparable[keys.length / 2];
            newVals = (Value[]) new Object[keys.length / 2];
            System.arraycopy(keys, 0, newKeys, 0, newKeys.length);
            System.arraycopy(vals, 0, newVals, 0, newVals.length);
        }
        keys = newKeys;
        vals = newVals;
    }
}
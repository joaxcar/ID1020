public class HashST<Key, Value> {
    private final static int SIZE = 4;
    int m = SIZE;
    int n;

    private SequentialSearchST<Key,Value>[] vals;

    public HashST() {
        vals = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            vals[i] = new SequentialSearchST<>();
        }
    }

    public void  put(Key key, Value val) {
        int hashCode = key.hashCode();
        int hash = (hashCode & 0x7fffffff) % m;
        n++;
        if (n >= m) {
            m = m * 2;
            resize(m);
        }
        vals[hash].put(key,val);
    }

    public Value  get(Key key) {
        int hashCode = key.hashCode();
        int hash = (hashCode & 0x7fffffff) % m;
        return vals[hash].get(key);
    }

    // public boolean  contains(Key key)
    // public void  delete(Key key)
    public boolean  isEmpty() {
        return n == 0;
    }

    public boolean contains(Key key) {
        Value val = get(key);
        return val != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (SequentialSearchST k : vals) {
            sb.append("[");
            sb.append(k);
            sb.append("] ");
        }
        return sb.toString();
    }

    private void resize(int m) {
        SequentialSearchST[] oldVals = vals;
        vals = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            vals[i] = new SequentialSearchST<>();
        }
        for (SequentialSearchST v : oldVals) {
            for (Object k : v.keys()) {
                put((Key) k, (Value) v.get(k));
            }
        }
    }
}

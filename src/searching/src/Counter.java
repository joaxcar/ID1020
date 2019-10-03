/**
 * Author: Johan Carlsson
 * Created: 2019-09-28
 *
 * Extends the ArrayST to a Counter for Strings. A new method range gives
 * the most frequent words starting from the given index
 *
 * Range [0,8]: the and of to a in I his
 * Range [3,8]: to a in I his that was it
 */

public class Counter extends ArrayST<String,Integer> {

    public Counter(){
        super();
    }

    public String[] range(int s, int r) {
        // Store all values in an index
        ArrayST<Integer,Queue<String>> found = new ArrayST<>();

        for (String k : keys()) {
            Integer val = get(k);
            if (!found.contains(val)) {
                found.put(val, new Queue<>());
            }
            Queue<String> q = found.get(val);
            q.enqueue(k);
         }

         // Extract the range
         String[] ret = new String[r];
         int start = 0;
         for (int i = 0; i < s + r; i++) {
             Queue<String> temp = found.get(found.max());
             for (String str : temp) {
                 if (start >= s) {
                     ret[i - s] = str;
                 }
                 start++;
                 i++;
                 if(i >= s + r) {
                     break;
                 }
             }
             i--;
             found.delete(found.max());
        }
        return ret;
    }
}

/**
 * Author: Johan Carlsson
 * Created: 2019-09-28
 *
 * Reads and counts all words in a textfile. Then askes for the most frequent words
 *
 * Range [0,8]: the and of to a in I his
 * Range [3,8]: to a in I his that was it
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class IndexCounter {

    public static void main(String[] args) throws IOException {
        Counter bst = new Counter();
        File file = new File("/Users/ladmin/skola/kurser/kth-id1020/src/searching/src/test.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        int index = 0;
        ArrayST<String,Queue<Integer>> found = new ArrayST<>();

        // Read lines from file
        while (in.ready()) {
            String line = in.readLine();
            String[] w = line.split("");
            int j = 0;
            while (j < w.length) {
                System.out.println(index);
                int cur = 0;
                while (w[j].equals(" ")) {
                    cur++;
                    j++;
                    index++;
                }

                StringBuilder sb = new StringBuilder();

                while (cur < w.length && ! w[cur].equals(" ")) {
                    sb.append(w[cur]);
                    cur++;
                    j++;
                }


                String str = sb.toString();
                System.out.println(sb.toString());
                if (!found.contains(str)) {
                    found.put(str, new Queue<>());
                }
                Queue<Integer> q = found.get(str);
                q.enqueue(index);
                index += cur;
            }
        }

        // find a key with the highest frequency count
        Queue<Integer> list = found.get("aa");
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}

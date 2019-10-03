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

public class WordCounter {

    public static void main(String[] args) throws IOException {
        Counter bst = new Counter();
        File file = new File("/Users/ladmin/skola/kurser/kth-id1020/src/searching/src/taleClean.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));

        // Read lines from file
        while (in.ready()) {
            String line = in.readLine();
            line.trim();

            // Split lines by white space
            String[] w = line.split("\\s+");
            for (String s : w) {
                // Skip empty words
                if(s.equals("")){
                    continue;
                }
                // Count
                else if (bst.contains(s)) {
                    bst.put(s, bst.get(s) + 1);
                } else {
                    bst.put(s, 1);
                }
            }
        }

        // find a key with the highest frequency count
        String[] request = bst.range(0,8);
        for (String s : request) {
            System.out.print(s + " ");
        }
    }
}

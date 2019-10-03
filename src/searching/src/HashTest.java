/**
 * Test how a series of strings are distributed by hashing in an array
 * Array size 10987 (a prime number)
 *
 * Distinct words: 10982
 * indices with zero hits: 4041
 * indices with more than one hit: 2913
 * max number of hits in a single index: 6
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HashTest {

    public static void main(String[] args) throws IOException{
        int m = 10987;

        int minlen = Integer.parseInt(args[0]);
        BST<String, Integer> bst = new BST<>();
        int[] count = new int[m];
        BufferedReader in = new BufferedReader(new FileReader(new File("/Users/ladmin/skola/kurser/kth-id1020/src/searching/src/taleClean.txt")));

        // Read all words
        while (in.ready()) {
            String line = in.readLine();
            String[] w = line.split("\\W+");
            for (String s : w) {
                if (s.length() < minlen) {
                    continue;
                }
                // Add distinct words
                if (! bst.contains(s)) {
                    bst.put(s,1);
                    int hash = (s.hashCode() & 0x7fffffff) % m;
                    count[hash]++;
                }
            }
        }

        // Count zeros and duplicates
        int zeros = 0;
        int over = 0;
        for (int i = 0; i < m; i++)  {
            if (count[i] == 0) {
                zeros++;
            }
            if (count[i] > 1) {
                over++;
            }
        }

        System.out.println(bst.size());
        System.out.println("indices with zero hits: " + zeros);
        System.out.println("indices with more than one hit: " + over);

    }
}

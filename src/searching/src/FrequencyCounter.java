/**
 * Number of lines: 100
 * Elapsed time: 0.058s
 * Chapter 45
 * distinct = 197
 * words    = 360
 *
 * Number of lines: 200
 * Elapsed time: 0.065s
 * the 82
 * distinct = 623
 * words    = 1269
 *
 * Number of lines: 400
 * Elapsed time: 0.1s
 * the 245
 * distinct = 1095
 * words    = 2951
 *
 * Number of lines: 800
 * Elapsed time: 0.157s
 * the 453
 * distinct = 1878
 * words    = 6458
 *
 * Number of lines: 1600
 * Elapsed time: 0.188s
 * the 822
 * distinct = 3090
 * words    = 13827
 *
 * Number of lines: 3200
 * Elapsed time: 0.229s
 * the 1574
 * distinct = 4593
 * words    = 27906
 *
 * ArrayST:
 * Number of lines: 100
 * Elapsed time: 0.049s
 * Chapter 45
 * distinct = 197
 * words    = 360
 *
 * Number of lines: 200
 * Elapsed time: 0.069s
 * the 82
 * distinct = 623
 * words    = 1269
 *
 * Number of lines: 400
 * Elapsed time: 0.114s
 * the 245
 * distinct = 1095
 * words    = 2951
 *
 * Number of lines: 800
 * Elapsed time: 0.174s
 * the 453
 * distinct = 1878
 * words    = 6458
 *
 * Number of lines: 1600
 * Elapsed time: 0.244s
 * the 822
 * distinct = 3090
 * words    = 13827
 *
 * Number of lines: 3200
 * Elapsed time: 0.47s
 * the 1574
 * distinct = 4593
 * words    = 27906
 *
 * Number of lines: 6400
 * Elapsed time: 0.811s
 * the 3003
 * distinct = 6768
 * words    = 55028
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FrequencyCounter {

    public static void main(String[] args) throws IOException{
        int distinct = 0, words = 0;
        int minlen = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        //BST<String, Integer> bst = new BST<String, Integer>();
        RBBST<String, Integer> bst = new RBBST<String, Integer>();
        //ArrayST<String, Integer> bst = new ArrayST<String, Integer>();
        BufferedReader in = new BufferedReader(new FileReader(new File("/Users/ladmin/skola/kurser/kth-id1020/src/searching/src/taleClean.txt")));
        long startTime = 0;
        while (n > 0 && in.ready()) {
            String line = in.readLine();
            //line.trim();
            String[] w = line.split("\\W+");
            for (String s : w) {
                if (s.length() < minlen) {
                    continue;
                }
                words++;
                long tempTime = System.currentTimeMillis();
                if (bst.contains(s)) {
                    bst.put(s, bst.get(s) + 1);
                } else {
                    bst.put(s, 1);
                    distinct++;
                }
                long tempStop = System.currentTimeMillis();
                startTime += tempStop - tempTime;
            }
            n--;
        }
        // find a key with the highest frequency count
        long tempTime = System.currentTimeMillis();
        String max = "";
        bst.put(max, 0);

        for (String word : bst.keys()) {
            if (bst.get(word) > bst.get(max))
                max = word;
        }
        long tempStop = System.currentTimeMillis();
        startTime += tempStop - tempTime;
        double elapsed = (startTime) / 1000.0;

        System.out.println("Number of lines: " + args[1]);
        System.out.println("Elapsed time: " + elapsed + "s");
        System.out.println(max + " " + bst.get(max));
        System.out.println("distinct = " + distinct);
        System.out.println("words    = " + words);
    }
}
